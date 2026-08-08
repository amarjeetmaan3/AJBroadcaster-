package com.amarjeetmaan.ajbroadcaster.director

class DirectorPresetManager {

    private val presets =
        LinkedHashMap<String, DirectorPreset>()

    fun save(
        preset: DirectorPreset
    ): Result<Unit> {

        if (preset.id.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Preset ID is required."
                )
            )
        }

        val updated =
            preset.copy(
                updatedAt =
                    System.currentTimeMillis()
            )

        presets[preset.id] =
            updated

        return Result.success(Unit)
    }

    fun load(
        id: String
    ): Result<DirectorPreset> {

        return presets[id]?.let {
            Result.success(it)
        }
            ?: Result.failure(
                NoSuchElementException(
                    "Preset not found: $id"
                )
            )
    }

    fun delete(
        id: String
    ): Boolean {
        return presets.remove(id) != null
    }

    fun all(): List<DirectorPreset> {
        return presets.values.toList()
    }

    fun clear() {
        presets.clear()
    }
}
