package com.amarjeetmaan.ajbroadcaster.camera

data class CameraFrame(
    val timestampNs: Long,
    val width: Int,
    val height: Int,
    val rotationDegrees: Int = 0,
    val isKeyFrame: Boolean = false
) {

    init {
        require(width > 0) {
            "Frame width must be greater than zero."
        }

        require(height > 0) {
            "Frame height must be greater than zero."
        }

        require(
            rotationDegrees in
                listOf(0, 90, 180, 270)
        ) {
            "Rotation must be 0, 90, 180 or 270 degrees."
        }
    }
}
