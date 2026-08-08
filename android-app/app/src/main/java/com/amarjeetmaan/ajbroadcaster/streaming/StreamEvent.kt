package com.amarjeetmaan.ajbroadcaster.streaming

/**
 * Events emitted by the streaming subsystem.
 *
 * These events can later be consumed by:
 *
 * - StreamingViewModel
 * - Director Portal
 * - Overlay system
 * - Notifications
 * - Diagnostics
 */
sealed class StreamEvent {

    /**
     * Stream is starting.
     */
    data object Starting : StreamEvent()

    /**
     * RTMP connection established.
     */
    data object Connected : StreamEvent()

    /**
     * Stream is live.
     */
    data class Live(
        val sessionId: String
    ) : StreamEvent()

    /**
     * Stream was stopped.
     */
    data class Stopped(
        val sessionId: String?
    ) : StreamEvent()

    /**
     * Connection was lost.
     */
    data class Disconnected(
        val reason: String
    ) : StreamEvent()

    /**
     * Reconnection started.
     */
    data class Reconnecting(
        val attempt: Int
    ) : StreamEvent()

    /**
     * Reconnection succeeded.
     */
    data object Reconnected : StreamEvent()

    /**
     * Stream health changed.
     */
    data class HealthChanged(
        val health: StreamHealth
    ) : StreamEvent()

    /**
     * Bitrate changed.
     */
    data class BitrateChanged(
        val bitrateKbps: Int
    ) : StreamEvent()

    /**
     * Stream failed.
     */
    data class Failed(
        val message: String
    ) : StreamEvent()
}
