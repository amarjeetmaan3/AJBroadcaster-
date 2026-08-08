package com.amarjeetmaan.ajbroadcaster.streaming.service

import com.amarjeetmaan.ajbroadcaster.streaming.StreamPacket
import com.amarjeetmaan.ajbroadcaster.streaming.StreamingConfig
import com.amarjeetmaan.ajbroadcaster.streaming.StreamingManager
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow

class StreamingServiceController(
    private val streamingManager:
        StreamingManager = StreamingManager()
) {

    private val _state =
        MutableStateFlow(
            StreamingServiceState()
        )

    val state: StateFlow<StreamingServiceState>
        get() = _state

    private val _events =
        MutableSharedFlow<StreamingServiceEvent>(
            replay = 0,
            extraBufferCapacity = 32
        )

    val events =
        _events.asSharedFlow()

    fun startService(): Result<Unit> {

        if (_state.value.running) {
            return Result.success(Unit)
        }

        _state.value =
            _state.value.copy(
                running = true,
                error = null
            )

        _events.tryEmit(
            StreamingServiceEvent.ServiceStarted
        )

        return Result.success(Unit)
    }

    fun configure(
        config: StreamingConfig
    ): Result<Unit> {

        if (!_state.value.running) {
            return failure(
                "Streaming service is not running."
            )
        }

        return streamingManager
            .configure(config)
            .onFailure {
                _state.value =
                    _state.value.copy(
                        error = it.message
                    )
            }
    }

    fun startStream(): Result<Unit> {

        if (!_state.value.running) {
            return failure(
                "Streaming service is not running."
            )
        }

        streamingManager
            .connect()
            .getOrElse {
                return failure(
                    it.message
                        ?: "Unable to connect to stream."
                )
            }

        streamingManager
            .start()
            .getOrElse {
                return failure(
                    it.message
                        ?: "Unable to start stream."
                )
            }

        _state.value =
            _state.value.copy(
                streamActive = true,
                error = null
            )

        _events.tryEmit(
            StreamingServiceEvent.StreamStarted
        )

        return Result.success(Unit)
    }

    fun send(
        packet: StreamPacket
    ): Result<Unit> {

        if (!_state.value.streamActive) {
            return failure(
                "Stream is not active."
            )
        }

        return streamingManager.send(
            packet
        )
    }

    fun stopStream(): Result<Unit> {

        if (!_state.value.streamActive) {
            return Result.success(Unit)
        }

        streamingManager.stop()
        streamingManager.disconnect()

        _state.value =
            _state.value.copy(
                streamActive = false
            )

        _events.tryEmit(
            StreamingServiceEvent.StreamStopped
        )

        return Result.success(Unit)
    }

    fun stopService(): Result<Unit> {

        stopStream()

        streamingManager.disconnect()

        _state.value =
            StreamingServiceState()

        _events.tryEmit(
            StreamingServiceEvent.ServiceStopped
        )

        return Result.success(Unit)
    }

    fun markForeground(
        foreground: Boolean
    ) {

        _state.value =
            _state.value.copy(
                foreground = foreground
            )
    }

    fun destroy() {

        stopStream()

        _state.value =
            StreamingServiceState()

        _events.tryEmit(
            StreamingServiceEvent.ServiceDestroyed
        )
    }

    fun manager(): StreamingManager {
        return streamingManager
    }

    private fun failure(
        message: String
    ): Result<Nothing> {

        _state.value =
            _state.value.copy(
                error = message
            )

        _events.tryEmit(
            StreamingServiceEvent.Error(
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
