package com.amarjeetmaan.ajbroadcaster.camera

data class CameraCapabilities(
    val supportedResolutions:
        List<Pair<Int, Int>>,

    val supportedFps:
        List<Int>,

    val supportsTorch:
        Boolean,

    val supportsZoom:
        Boolean,

    val supportsFocus:
        Boolean
) {

    fun supportsResolution(
        width: Int,
        height: Int
    ): Boolean {

        return supportedResolutions.any {
            it.first == width &&
                it.second == height
        }
    }

    fun supportsFps(
        fps: Int
    ): Boolean {

        return fps in supportedFps
    }
}
