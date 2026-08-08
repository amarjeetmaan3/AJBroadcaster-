package com.amarjeetmaan.ajbroadcaster.audio

class AudioMixer {

    private val sources =
        LinkedHashMap<String, AudioSource>()

    fun add(
        source: AudioSource
    ): Result<Unit> {

        if (source.id.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Audio source ID is required."
                )
            )
        }

        if (source.gain !in 0f..1f) {
            return Result.failure(
                IllegalArgumentException(
                    "Source gain must be between 0 and 1."
                )
            )
        }

        sources[source.id] =
            source

        return Result.success(Unit)
    }

    fun remove(
        sourceId: String
    ): Boolean {

        return sources.remove(
            sourceId
        ) != null
    }

    fun updateGain(
        sourceId: String,
        gain: Float
    ): Result<Unit> {

        if (gain !in 0f..1f) {
            return Result.failure(
                IllegalArgumentException(
                    "Gain must be between 0 and 1."
                )
            )
        }

        val source =
            sources[sourceId]
                ?: return Result.failure(
                    NoSuchElementException(
                        "Audio source not found: $sourceId"
                    )
                )

        sources[sourceId] =
            source.copy(
                gain = gain
            )

        return Result.success(Unit)
    }

    fun setEnabled(
        sourceId: String,
        enabled: Boolean
    ): Result<Unit> {

        val source =
            sources[sourceId]
                ?: return Result.failure(
                    NoSuchElementException(
                        "Audio source not found: $sourceId"
                    )
                )

        sources[sourceId] =
            source.copy(
                enabled = enabled
            )

        return Result.success(Unit)
    }

    fun sources(): List<AudioSource> {
        return sources.values.toList()
    }

    fun activeSources(): List<AudioSource> {
        return sources.values.filter {
            it.enabled
        }
    }

    fun clear() {
        sources.clear()
    }
}
