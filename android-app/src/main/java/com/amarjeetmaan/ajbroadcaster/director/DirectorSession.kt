package com.amarjeetmaan.ajbroadcaster.director

data class DirectorSession(
    val id: String,
    val productionName: String,
    val matchId: String? = null,
    val activeScene: DirectorScene,
    val startedAt: Long =
        System.currentTimeMillis()
)
