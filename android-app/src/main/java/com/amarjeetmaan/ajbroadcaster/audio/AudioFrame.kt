package com.amarjeetmaan.ajbroadcaster.audio

data class AudioFrame(
    val timestampNs: Long,
    val sampleRate: Int,
    val channels: Int,
    val samples: ShortArray
) {

    init {
        require(sampleRate > 0) {
            "Sample rate must be greater than zero."
        }

        require(channels > 0) {
            "Audio channels must be greater than zero."
        }
    }

    val sampleCount: Int
        get() =
            samples.size /
                channels

    fun copySamples(): ShortArray {
        return samples.copyOf()
    }
}
