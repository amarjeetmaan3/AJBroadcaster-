package com.amarjeetmaan.ajbroadcaster.streaming

import com.amarjeetmaan.ajbroadcaster.data.model.StreamSession

/**
 * Runtime state of the streaming engine.
 */
sealed class StreamState {

    /**
     * No stream is currently active.
     */
    data object Idle : StreamState()

    /**
     * Engine is connecting to RTMP server.
     */
    data class Connecting(
        val session: StreamSession
    ) : StreamState()

    /**
     * Stream is live.
     */
    data class Live(
        val session: StreamSession
    ) : StreamState()

    /**
     * Stream is reconnecting.
     */
    data class Reconnecting(
        val session: StreamSession?
    ) : StreamState()

    /**
     * Stream has stopped.
     */
    data class Stopped(
        val session: StreamSession?
    ) : StreamState()

    /**
     * Stream failed.
     */
    data class Failed(
        val session: StreamSession?,
        val message: String
    ) : StreamState()
}
