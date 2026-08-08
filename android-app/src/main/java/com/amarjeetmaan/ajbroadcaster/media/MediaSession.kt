package com.amarjeetmaan.ajbroadcaster.media

data class MediaSession(
    val id: String,
    val name: String,
    val width: Int = 1920,
    val height: Int = 1080,
    val videoFps: Int = 30,
    val audioSampleRate: Int = 48_000,
    val audioChannels: Int = 2,
    val startedAt: Long = System.currentTimeMillis()
) {

    init {
        require(id.isNotBlank()) {
            "Media session ID is required."
        }

        require(name.isNotBlank()) {
            "Media session name is required."
        }

        require(width > 0) {
            "Media width must be greater than zero."
        }

        require(height > 0) {
            "Media height must be greater than zero."
        }

        require(videoFps > 0) {
            "Video FPS must be greater than zero."
        }

        require(audioSampleRate > 0) {
            "Audio sample rate must be greater than zero."
        }

        require(audioChannels > 0) {
            "Audio channels must be greater than zero."
        }
    }
}
