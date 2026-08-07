package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents application-wide settings and user preferences.
 *
 * This model stores configurable settings only.
 * Business logic for applying these settings belongs elsewhere.
 */
data class AppSettings(

    /**
     * Unique settings ID.
     */
    val id: String = "",

    /**
     * User ID owning these settings.
     */
    val userId: String = "",

    /**
     * Application theme.
     *
     * Examples:
     * System
     * Light
     * Dark
     */
    val theme: String = "System",

    /**
     * Application language.
     *
     * Examples:
     * English
     * Hindi
     */
    val language: String = "English",

    /**
     * Notifications enabled.
     */
    val notificationsEnabled: Boolean = true,

    /**
     * Sound effects enabled.
     */
    val soundEnabled: Boolean = true,

    /**
     * Vibration enabled.
     */
    val vibrationEnabled: Boolean = true,

    /**
     * Default streaming resolution.
     *
     * Example:
     * 1920x1080
     * 1280x720
     */
    val defaultResolution: String = "1920x1080",

    /**
     * Default video bitrate (kbps).
     */
    val defaultVideoBitrate: Int = 4000,

    /**
     * Default frame rate.
     */
    val defaultFrameRate: Int = 30,

    /**
     * Automatic recording enabled.
     */
    val autoRecording: Boolean = false,

    /**
     * Automatic backup enabled.
     */
    val autoBackup: Boolean = true,

    /**
     * Broadcast graphics enabled.
     */
    val graphicsEnabled: Boolean = true,

    /**
     * Animation effects enabled.
     */
    val animationsEnabled: Boolean = true,

    /**
     * Keep screen awake during streaming.
     */
    val keepScreenOn: Boolean = true,

    /**
     * Last update timestamp.
     */
    val updatedAt: Long = 0L
)
