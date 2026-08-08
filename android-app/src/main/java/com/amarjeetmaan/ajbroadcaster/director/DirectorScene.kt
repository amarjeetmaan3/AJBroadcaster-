package com.amarjeetmaan.ajbroadcaster.director

data class DirectorScene(
    val id: String,
    val name: String,
    val cameraId: String? = null,
    val overlayIds: List<String> =
        emptyList(),
    val fullScreenGraphic: String? = null,
    val durationMs: Long = 0L
)
