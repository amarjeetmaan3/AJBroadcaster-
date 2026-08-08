package com.amarjeetmaan.ajbroadcaster.media

sealed class MediaState {

    data object Idle : MediaState()

    data class Starting(
        val session: MediaSession
    ) : MediaState()

    data class Running(
        val session: MediaSession,
        val videoFrames: Long = 0L,
        val audioFrames: Long = 0L
    ) : MediaState()

    data class Paused(
        val session: MediaSession
    ) : MediaState()

    data class Stopped(
        val session: MediaSession
    ) : MediaState()

    data class Error(
        val message: String
    ) : MediaState()
}
