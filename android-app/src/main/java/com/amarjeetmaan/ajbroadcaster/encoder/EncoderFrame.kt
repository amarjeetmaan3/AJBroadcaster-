package com.amarjeetmaan.ajbroadcaster.encoder

data class EncoderFrame(
    val timestampUs: Long,
    val type: EncoderFrameType,
    val data: ByteArray,
    val width: Int = 0,
    val height: Int = 0,
    val sampleRate: Int = 0,
    val channels: Int = 0,
    val keyFrame: Boolean = false
) {

    init {
        require(data.isNotEmpty()) {
            "Encoder frame data cannot be empty."
        }

        when (type) {

            EncoderFrameType.VIDEO -> {
                require(width > 0) {
                    "Video frame width is required."
                }

                require(height > 0) {
                    "Video frame height is required."
                }
            }

            EncoderFrameType.AUDIO -> {
                require(sampleRate > 0) {
                    "Audio sample rate is required."
                }

                require(channels > 0) {
                    "Audio channels are required."
                }
            }
        }
    }
}

enum class EncoderFrameType {
    VIDEO,
    AUDIO
}
