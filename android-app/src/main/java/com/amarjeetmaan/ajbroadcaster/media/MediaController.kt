package com.amarjeetmaan.ajbroadcaster.media

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow

class MediaController {

    private val _state =
        MutableStateFlow<MediaState>(
            MediaState.Idle
        )

    val state: StateFlow<MediaState>
        get() = _state

    private val _events =
        MutableSharedFlow<MediaEvent>(
            replay = 0,
            extraBufferCapacity = 64
        )

    val events =
        _events.asSharedFlow()

    fun start(
        session: MediaSession
    ): Result<Unit> {

        if (_state.value is MediaState.Running) {
            return Result.failure(
                IllegalStateException(
                    "Media session is already running."
                )
            )
        }

        _state.value =
            MediaState.Starting(
                session
            )

        _state.value =
            MediaState.Running(
                session = session
            )

        _events.tryEmit(
            MediaEvent.Started(
                session.id
            )
        )

        return Result.success(Unit)
    }

    fun stop(): Result<Unit> {

        val current =
            _state.value

        val session =
            when (current) {
                is MediaState.Running ->
                    current.session

                is MediaState.Paused ->
                    current.session

                is MediaState.Starting ->
                    current.session

                else ->
                    return Result.failure(
                        IllegalStateException(
                            "No active media session."
                        )
                    )
            }

        _state.value =
            MediaState.Stopped(
                session
            )

        _events.tryEmit(
            MediaEvent.Stopped(
                session.id
            )
        )

        return Result.success(Unit)
    }

    fun pause(): Result<Unit> {

        val current =
            _state.value

        if (current !is MediaState.Running) {
            return Result.failure(
                IllegalStateException(
                    "Media session is not running."
                )
            )
        }

        _state.value =
            MediaState.Paused(
                current.session
            )

        _events.tryEmit(
            MediaEvent.Paused(
                current.session.id
            )
        )

        return Result.success(Unit)
    }

    fun resume(): Result<Unit> {

        val current =
            _state.value

        if (current !is MediaState.Paused) {
            return Result.failure(
                IllegalStateException(
                    "Media session is not paused."
                )
            )
        }

        _state.value =
            MediaState.Running(
                session = current.session
            )

        _events.tryEmit(
            MediaEvent.Resumed(
                current.session.id
            )
        )

        return Result.success(Unit)
    }

    fun submitVideo(
        frame: MediaFrame
    ): Result<Unit> {

        val current =
            _state.value

        if (current !is MediaState.Running) {
            return Result.failure(
                IllegalStateException(
                    "Media session is not running."
                )
            )
        }

        _state.value =
            current.copy(
                videoFrames =
                    current.videoFrames + 1
            )

        _events.tryEmit(
            MediaEvent.VideoFrameReceived(
                frame.timestampNs
            )
        )

        return Result.success(Unit)
    }

    fun submitAudio(
        frame: MediaFrame
    ): Result<Unit> {

        val current =
            _state.value

        if (current !is MediaState.Running) {
            return Result.failure(
                IllegalStateException(
                    "Media session is not running."
                )
            )
        }

        _state.value =
            current.copy(
                audioFrames =
                    current.audioFrames + 1
            )

        _events.tryEmit(
            MediaEvent.AudioFrameReceived(
                frame.timestampNs
            )
        )

        return Result.success(Unit)
    }

    fun reset() {
        _state.value =
            MediaState.Idle
    }

    fun fail(
        message: String
    ): Result<Unit> {

        _state.value =
            MediaState.Error(
                message
            )

        _events.tryEmit(
            MediaEvent.Error(
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
