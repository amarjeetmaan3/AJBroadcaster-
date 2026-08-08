package com.amarjeetmaan.ajbroadcaster.media

data class MediaFrame(
    val timestampNs: Long,
    val type: MediaFrameType,
    val width: Int = 0,
    val height: Int = 0,
    val sampleRate: Int = 0,
    val channels: Int = 0,
    val keyFrame: Boolean = false
) {

    init {

        when (type) {

            MediaFrameType.VIDEO -> {
                require(width > 0) {
                    "Video frame width must be greater than zero."
                }

                require(height > 0) {
                    "Video frame height must be greater than zero."
                }
            }

            MediaFrameType.AUDIO -> {
                require(sampleRate > 0) {
                    "Audio sample rate must be greater than zero."
                }

                require(channels > 0) {
                    "Audio channels must be greater than zero."
                }
            }
        }
    }
}

enum class MediaFrameType {
    VIDEO,
    AUDIO
}
