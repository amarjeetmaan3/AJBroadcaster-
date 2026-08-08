package com.amarjeetmaan.ajbroadcaster.audio

data class AudioSource(
    val id: String,
    val name: String,
    val type: AudioSourceType,
    val enabled: Boolean = true,
    val gain: Float = 1f
) {

    init {
        require(id.isNotBlank()) {
            "Audio source ID is required."
        }

        require(name.isNotBlank()) {
            "Audio source name is required."
        }

        require(gain in 0f..1f) {
            "Audio source gain must be between 0 and 1."
        }
    }
}

enum class AudioSourceType {
    MICROPHONE,
    SYSTEM,
    CAMERA,
    EXTERNAL,
    MIXED
}
