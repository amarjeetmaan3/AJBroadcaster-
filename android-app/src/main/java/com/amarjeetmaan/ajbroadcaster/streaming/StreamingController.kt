package com.amarjeetmaan.ajbroadcaster.streaming

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow

class StreamingController {

    private val _state =
        MutableStateFlow<StreamingState>(
            StreamingState.Idle
        )

    val state: StateFlow<StreamingState>
        get() = _state

    private val _events =
        MutableSharedFlow<StreamingEvent>(
            replay = 0,
            extraBufferCapacity = 64
        )

    val events =
        _events.asSharedFlow()

    private var config: StreamingConfig? = null

    fun configure(
        newConfig: StreamingConfig
    ): Result<Unit> {

        if (_state.value is StreamingState.Live) {
            return fail(
                "Cannot configure while streaming."
            )
        }

        config = newConfig

        _state.value =
            StreamingState.Configured(
                newConfig
            )

        _events.tryEmit(
            StreamingEvent.Configured
        )

        return Result.success(Unit)
    }

    fun connect(): Result<Unit> {

        val currentConfig =
            config
                ?: return fail(
                    "Streaming configuration is missing."
                )

        if (
            _state.value is StreamingState.Connected ||
            _state.value is StreamingState.Live
        ) {
            return Result.success(Unit)
        }

        _state.value =
            StreamingState.Connecting(
                currentConfig
            )

        _state.value =
            StreamingState.Connected(
                currentConfig
            )

        _events.tryEmit(
            StreamingEvent.Connected
        )

        return Result.success(Unit)
    }

    fun start(): Result<Unit> {

        val currentConfig =
            config
                ?: return fail(
                    "Streaming configuration is missing."
                )

        if (
            _state.value !is StreamingState.Connected
        ) {
            return fail(
                "Streaming connection is not established."
            )
        }

        _state.value =
            StreamingState.Live(
                currentConfig
            )

        _events.tryEmit(
            StreamingEvent.Started
        )

        return Result.success(Unit)
    }

    fun stop(): Result<Unit> {

        val currentConfig =
            config
                ?: return fail(
                    "Streaming configuration is missing."
                )

        if (
            _state.value !is StreamingState.Live
        ) {
            return Result.success(Unit)
        }

        _state.value =
            StreamingState.Connected(
                currentConfig
            )

        _events.tryEmit(
            StreamingEvent.Stopped
        )

        return Result.success(Unit)
    }

    fun disconnect(): Result<Unit> {

        if (
            _state.value is StreamingState.Live
        ) {
            stop()
        }

        _state.value =
            StreamingState.Idle

        _events.tryEmit(
            StreamingEvent.Disconnected
        )

        return Result.success(Unit)
    }

    fun send(
        packet: StreamPacket
    ): Result<Unit> {

        if (
            _state.value !is StreamingState.Live
        ) {
            return fail(
                "Stream is not live."
            )
        }

        if (packet.data.isEmpty()) {
            return fail(
                "Cannot send an empty packet."
            )
        }

        _events.tryEmit(
            StreamingEvent.PacketSent(
                packet.type,
                packet.timestampUs
            )
        )

        return Result.success(Unit)
    }

    private fun fail(
        message: String
    ): Result<Nothing> {

        _state.value =
            StreamingState.Error(
                message
            )

        _events.tryEmit(
            StreamingEvent.Error(
                message
            )
        )

        return Result.failure(
            IllegalStateException(message)
        )
    }
}
