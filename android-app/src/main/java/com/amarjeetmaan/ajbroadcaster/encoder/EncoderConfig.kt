package com.amarjeetmaan.ajbroadcaster.encoder

data class EncoderConfig(
    val codec: EncoderCodec = EncoderCodec.H264,
    val width: Int = 1920,
    val height: Int = 1080,
    val fps: Int = 30,
    val bitrate: Int = 4_000_000,
    val keyFrameIntervalSeconds: Int = 2,
    val profile: EncoderProfile =
        EncoderProfile.MAIN
) {

    init {
        require(width > 0) {
            "Encoder width must be greater than zero."
        }

        require(height > 0) {
            "Encoder height must be greater than zero."
        }

        require(fps > 0) {
            "Encoder FPS must be greater than zero."
        }

        require(bitrate > 0) {
            "Encoder bitrate must be greater than zero."
        }

        require(keyFrameIntervalSeconds > 0) {
            "Key-frame interval must be greater than zero."
        }
    }
}

enum class EncoderCodec {
    H264,
    HEVC,
    AV1
}

enum class EncoderProfile {
    BASELINE,
    MAIN,
    HIGH
}
