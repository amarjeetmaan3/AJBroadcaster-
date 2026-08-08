package com.amarjeetmaan.ajbroadcaster.director

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow

class DirectorController {

    private val _state =
        MutableStateFlow<DirectorState>(
            DirectorState.Idle
        )

    val state: StateFlow<DirectorState>
        get() = _state

    private val _events =
        MutableSharedFlow<DirectorEvent>(
            replay = 0,
            extraBufferCapacity = 32
        )

    val events =
        _events.asSharedFlow()

    fun startSession(
        session: DirectorSession
    ): Result<Unit> {

        if (session.id.isBlank()) {
            return fail(
                "Session ID is required."
            )
        }

        _state.value =
            DirectorState.Live(
                session = session,
                scene = session.activeScene
            )

        _events.tryEmit(
            DirectorEvent.SessionStarted(
                session.id
            )
        )

        return Result.success(Unit)
    }

    fun stopSession(): Result<Unit> {

        val current =
            _state.value

        if (current !is DirectorState.Live) {
            return Result.failure(
                IllegalStateException(
                    "No live director session."
                )
            )
        }

        _state.value =
            DirectorState.Idle

        _events.tryEmit(
            DirectorEvent.SessionStopped(
                current.session.id
            )
        )

        return Result.success(Unit)
    }

    fun setScene(
        scene: DirectorScene
    ): Result<Unit> {

        if (scene.id.isBlank()) {
            return fail(
                "Scene ID is required."
            )
        }

        val current =
            _state.value

        if (current !is DirectorState.Live) {
            return Result.failure(
                IllegalStateException(
                    "No live session."
                )
            )
        }

        val session =
            current.session.copy(
                activeScene = scene
            )

        _state.value =
            DirectorState.Live(
                session = session,
                scene = scene
            )

        _events.tryEmit(
            DirectorEvent.SceneChanged(
                scene.id
            )
        )

        return Result.success(Unit)
    }

    fun setBusy(
        busy: Boolean
    ) {

        val current =
            _state.value

        if (current is DirectorState.Live) {
            _state.value =
                DirectorState.Busy(
                    busy = busy,
                    session = current.session
                )
        }
    }

    fun commandExecuted(
        command: String
    ) {
        _events.tryEmit(
            DirectorEvent.CommandExecuted(
                command
            )
        )
    }

    private fun fail(
        message: String
    ): Result<Unit> {

        _state.value =
            DirectorState.Error(
                message
            )

        _events.tryEmit(
            DirectorEvent.Error(
                message
            )
        )

        return Result.failure(
            IllegalArgumentException(
                message
            )
        )
    }
}
