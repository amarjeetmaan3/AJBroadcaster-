package com.amarjeetmaan.ajbroadcaster.camera

data class CameraDevice(
    val id: String,
    val name: String,
    val lens: CameraLens = CameraLens.BACK,
    val width: Int = 1920,
    val height: Int = 1080,
    val fps: Int = 30,
    val supportsTorch: Boolean = false
)

enum class CameraLens {
    FRONT,
    BACK,
    EXTERNAL
}
