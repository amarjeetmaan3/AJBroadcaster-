package com.amarjeetmaan.ajbroadcaster.camera

import kotlinx.coroutines.flow.StateFlow

class CameraEngine(
    private val controller: CameraController
) {

    val state: StateFlow<CameraState>
        get() = controller.state

    val events
        get() = controller.events

    fun open(
        camera: CameraDevice
    ): Result<Unit> {
        return controller.open(camera)
    }

    fun start(): Result<Unit> {
        return controller.start()
    }

    fun stop(): Result<Unit> {
        return controller.stop()
    }

    fun close(): Result<Unit> {
        return controller.close()
    }

    fun switch(
        camera: CameraDevice
    ): Result<Unit> {
        return controller.switch(camera)
    }
}
