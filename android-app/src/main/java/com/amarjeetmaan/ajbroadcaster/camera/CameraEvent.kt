package com.amarjeetmaan.ajbroadcaster.camera

sealed class CameraEvent {

    data class Opened(
        val cameraId: String
    ) : CameraEvent()

    data class Started(
        val cameraId: String
    ) : CameraEvent()

    data class Stopped(
        val cameraId: String
    ) : CameraEvent()

    data class Closed(
        val cameraId: String
    ) : CameraEvent()

    data class Switched(
        val cameraId: String
    ) : CameraEvent()

    data class FrameReceived(
        val cameraId: String,
        val timestampNs: Long
    ) : CameraEvent()

    data class Error(
        val message: String
    ) : CameraEvent()
}
