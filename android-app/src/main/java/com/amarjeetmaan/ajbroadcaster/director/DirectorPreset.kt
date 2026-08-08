package com.amarjeetmaan.ajbroadcaster.director

data class DirectorPreset(
    val id: String,
    val name: String,
    val scene: DirectorScene,
    val createdAt: Long =
        System.currentTimeMillis(),
    val updatedAt: Long =
        System.currentTimeMillis()
)
