package com.amarjeetmaan.ajbroadcaster.audio

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow

class AudioController {

    private val _state =
        MutableStateFlow(
            AudioState()
        )

    val state: StateFlow<AudioState>
        get() = _state

    private val _events =
        MutableSharedFlow<AudioEvent>(
            replay = 0,
            extraBufferCapacity = 32
        )

    val events =
        _events.asSharedFlow()

    fun start(): Result<Unit> {

        if (_state.value.running) {
            return Result.success(Unit)
        }

        _state.value =
            _state.value.copy(
                running = true
            )

        _events.tryEmit(
            AudioEvent.Started
        )

        return Result.success(Unit)
    }

    fun stop(): Result<Unit> {

        if (!_state.value.running) {
            return Result.success(Unit)
        }

        _state.value =
            _state.value.copy(
                running = false
            )

        _events.tryEmit(
            AudioEvent.Stopped
        )

        return Result.success(Unit)
    }

    fun mute(
        muted: Boolean
    ): Result<Unit> {

        _state.value =
            _state.value.copy(
                muted = muted
            )

        _events.tryEmit(
            AudioEvent.MuteChanged(
                muted
            )
        )

        return Result.success(Unit)
    }

    fun setGain(
        gain: Float
    ): Result<Unit> {

        if (gain !in 0f..1f) {
            return Result.failure(
                IllegalArgumentException(
                    "Gain must be between 0 and 1."
                )
            )
        }

        _state.value =
            _state.value.copy(
                gain = gain
            )

        _events.tryEmit(
            AudioEvent.GainChanged(
                gain
            )
        )

        return Result.success(Unit)
    }

    fun reset(): Result<Unit> {

        _state.value =
            AudioState()

        return Result.success(Unit)
    }
}
