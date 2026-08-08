package com.amarjeetmaan.ajbroadcaster.camera

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow

class CameraController {

    private val _state =
        MutableStateFlow<CameraState>(
            CameraState.Idle
        )

    val state: StateFlow<CameraState>
        get() = _state

    private val _events =
        MutableSharedFlow<CameraEvent>(
            replay = 0,
            extraBufferCapacity = 32
        )

    val events =
        _events.asSharedFlow()

    fun open(
        camera: CameraDevice
    ): Result<Unit> {

        if (camera.id.isBlank()) {
            return fail(
                "Camera ID is required."
            )
        }

        _state.value =
            CameraState.Ready(
                camera
            )

        _events.tryEmit(
            CameraEvent.Opened(
                camera.id
            )
        )

        return Result.success(Unit)
    }

    fun start(): Result<Unit> {

        val camera =
            currentCamera()
                ?: return fail(
                    "No camera is open."
                )

        _state.value =
            CameraState.Running(
                camera
            )

        _events.tryEmit(
            CameraEvent.Started(
                camera.id
            )
        )

        return Result.success(Unit)
    }

    fun stop(): Result<Unit> {

        val camera =
            currentCamera()
                ?: return fail(
                    "No camera is open."
                )

        _state.value =
            CameraState.Ready(
                camera
            )

        _events.tryEmit(
            CameraEvent.Stopped(
                camera.id
            )
        )

        return Result.success(Unit)
    }

    fun close(): Result<Unit> {

        val camera =
            currentCamera()

        if (camera != null) {
            _events.tryEmit(
                CameraEvent.Closed(
                    camera.id
                )
            )
        }

        _state.value =
            CameraState.Idle

        return Result.success(Unit)
    }

    fun switch(
        camera: CameraDevice
    ): Result<Unit> {

        if (camera.id.isBlank()) {
            return fail(
                "Camera ID is required."
            )
        }

        val oldCamera =
            currentCamera()

        _state.value =
            CameraState.Ready(
                camera
            )

        _events.tryEmit(
            CameraEvent.Switched(
                camera.id
            )
        )

        if (
            oldCamera != null &&
            oldCamera.id != camera.id
        ) {
            _events.tryEmit(
                CameraEvent.Closed(
                    oldCamera.id
                )
            )
        }

        return Result.success(Unit)
    }

    private fun currentCamera():
        CameraDevice? {

        return when (
            val current = _state.value
        ) {

            is CameraState.Ready ->
                current.camera

            is CameraState.Running ->
                current.camera

            else ->
                null
        }
    }

    private fun fail(
        message: String
    ): Result<Unit> {

        _state.value =
            CameraState.Error(
                message
            )

        _events.tryEmit(
            CameraEvent.Error(
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
