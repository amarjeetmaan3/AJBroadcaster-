package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents a live streaming session.
 *
 * This model stores streaming configuration and runtime state.
 * Actual streaming logic belongs to the streaming engine.
 */
data class StreamSession(

    /**
     * Unique session ID.
     */
    val id: String = "",

    /**
     * Match ID associated with this stream.
     */
    val matchId: String = "",

    /**
     * Streaming platform.
     *
     * Examples:
     * YouTube
     * Facebook
     * Custom RTMP
     */
    val platform: String = "",

    /**
     * RTMP server URL.
     */
    val rtmpUrl: String = "",

    /**
     * Stream key.
     */
    val streamKey: String = "",

    /**
     * Output resolution.
     *
     * Example:
     * 1920x1080
     * 1280x720
     */
    val resolution: String = "",

    /**
     * Video bitrate (kbps).
     */
    val videoBitrate: Int = 0,

    /**
     * Audio bitrate (kbps).
     */
    val audioBitrate: Int = 0,

    /**
     * Frames per second.
     */
    val frameRate: Int = 30,

    /**
     * Streaming protocol.
     *
     * Example:
     * RTMP
     * RTMPS
     */
    val protocol: String = "RTMP",

    /**
     * Current stream status.
     *
     * Examples:
     * Idle
     * Connecting
     * Live
     * Reconnecting
     * Stopped
     * Failed
     */
    val status: String = "",

    /**
     * Whether recording is enabled.
     */
    val isRecording: Boolean = false,

    /**
     * Current upload speed (kbps).
     */
    val uploadSpeed: Double = 0.0,

    /**
     * Current network quality.
     *
     * Examples:
     * Excellent
     * Good
     * Fair
     * Poor
     */
    val networkQuality: String = "",

    /**
     * Stream start timestamp.
     */
    val startedAt: Long = 0L,

    /**
     * Stream end timestamp.
     */
    val endedAt: Long = 0L,

    /**
     * Last update timestamp.
     */
    val updatedAt: Long = 0L
)
