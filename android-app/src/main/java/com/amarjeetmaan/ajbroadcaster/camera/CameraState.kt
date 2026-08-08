package com.amarjeetmaan.ajbroadcaster.camera

sealed class CameraState {

    data object Idle : CameraState()

    data class Ready(
        val camera: CameraDevice
    ) : CameraState()

    data class Running(
        val camera: CameraDevice
    ) : CameraState()

    data class Error(
        val message: String
    ) : CameraState()
}
