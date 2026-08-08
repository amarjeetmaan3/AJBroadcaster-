package com.amarjeetmaan.ajbroadcaster.audio

data class AudioConfig(
    val sampleRate: Int = 48_000,
    val channels: Int = 2,
    val bitrate: Int = 128_000,
    val bufferSize: Int = 2_048,
    val echoCancellation: Boolean = true,
    val noiseSuppression: Boolean = true,
    val automaticGainControl: Boolean = true
) {

    init {
        require(sampleRate > 0) {
            "Sample rate must be greater than zero."
        }

        require(
            channels == 1 || channels == 2
        ) {
            "Audio channels must be 1 or 2."
        }

        require(bitrate > 0) {
            "Audio bitrate must be greater than zero."
        }

        require(bufferSize > 0) {
            "Audio buffer size must be greater than zero."
        }
    }
}
