package com.amarjeetmaan.ajbroadcaster.encoder

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow

class EncoderController {

    private val _state =
        MutableStateFlow<EncoderState>(
            EncoderState.Idle
        )

    val state: StateFlow<EncoderState>
        get() = _state

    private val _events =
        MutableSharedFlow<EncoderEvent>(
            replay = 0,
            extraBufferCapacity = 64
        )

    val events =
        _events.asSharedFlow()

    private var config: EncoderConfig? = null

    private val packetQueue =
        ArrayDeque<EncodedPacket>()

    fun configure(
        newConfig: EncoderConfig
    ): Result<Unit> {

        if (_state.value is EncoderState.Running) {
            return failure(
                "Cannot configure encoder while running."
            )
        }

        config = newConfig

        _state.value =
            EncoderState.Configured(
                newConfig
            )

        _events.tryEmit(
            EncoderEvent.Configured(
                newConfig.codec
            )
        )

        return Result.success(Unit)
    }

    fun start(): Result<Unit> {

        val currentConfig =
            config
                ?: return failure(
                    "Encoder has not been configured."
                )

        _state.value =
            EncoderState.Running(
                currentConfig
            )

        _events.tryEmit(
            EncoderEvent.Started(
                currentConfig.codec
            )
        )

        return Result.success(Unit)
    }

    fun stop(): Result<Unit> {

        val current =
            _state.value

        if (current !is EncoderState.Running) {
            return failure(
                "Encoder is not running."
            )
        }

        _state.value =
            EncoderState.Stopped(
                current.config
            )

        _events.tryEmit(
            EncoderEvent.Stopped
        )

        return Result.success(Unit)
    }

    fun encode(
        frame: EncoderFrame
    ): Result<EncodedPacket> {

        val current =
            _state.value

        if (current !is EncoderState.Running) {
            return failure(
                "Encoder is not running."
            )
        }

        if (frame.type == EncoderFrameType.VIDEO &&
            frame.width != current.config.width
        ) {
            return failure(
                "Video frame width does not match encoder configuration."
            )
        }

        val packet =
            EncodedPacket(
                timestampUs =
                    frame.timestampUs,
                type =
                    frame.type,
                keyFrame =
                    frame.keyFrame,
                data =
                    frame.data.copyOf()
            )

        packetQueue.addLast(packet)

        _events.tryEmit(
            EncoderEvent.PacketEncoded(
                packet.type,
                packet.timestampUs
            )
        )

        return Result.success(packet)
    }

    fun flush():
        Result<List<EncodedPacket>> {

        val packets =
            packetQueue.toList()

        packetQueue.clear()

        _events.tryEmit(
            EncoderEvent.Flushed(
                packets.size
            )
        )

        return Result.success(
            packets
        )
    }

    fun release() {

        packetQueue.clear()
        config = null

        _state.value =
            EncoderState.Idle

        _events.tryEmit(
            EncoderEvent.Released
        )
    }

    private fun failure(
        message: String
    ): Result<Nothing> {

        _state.value =
            EncoderState.Error(
                message
            )

        _events.tryEmit(
            EncoderEvent.Error(
                message
            )
        )

        return Result.failure(
            IllegalStateException(
                message
            )
        )
    }
}
