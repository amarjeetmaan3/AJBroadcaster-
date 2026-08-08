package com.amarjeetmaan.ajbroadcaster.camera

data class CameraConfig(
    val width: Int = 1920,
    val height: Int = 1080,
    val fps: Int = 30,
    val bitrate: Int = 4_000_000,
    val enableAudio: Boolean = true,
    val mirrorFrontCamera: Boolean = true
) {

    init {
        require(width > 0) {
            "Camera width must be greater than zero."
        }

        require(height > 0) {
            "Camera height must be greater than zero."
        }

        require(fps > 0) {
            "Camera FPS must be greater than zero."
        }

        require(bitrate > 0) {
            "Camera bitrate must be greater than zero."
        }
    }
}
