package com.amarjeetmaan.ajbroadcaster.camera

class CameraManager(
    private val controller: CameraController =
        CameraController()
) {

    fun open(
        camera: CameraDevice
    ): Result<Unit> {
        return controller.open(
            camera
        )
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
        return controller.switch(
            camera
        )
    }

    /**
     * Returns the cameras known to the application.
     *
     * Actual Android hardware discovery will be implemented
     * by the platform CameraX layer.
     */
    fun availableCameras():
        List<CameraDevice> {

        return listOf(
            CameraDevice(
                id = "back",
                name = "Back Camera",
                lens = CameraLens.BACK
            ),

            CameraDevice(
                id = "front",
                name = "Front Camera",
                lens = CameraLens.FRONT
            )
        )
    }
}
