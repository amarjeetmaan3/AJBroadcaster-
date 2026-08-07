package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents a camera configuration for broadcasting.
 *
 * This model stores camera settings only.
 * Camera control logic belongs to the camera engine.
 */
data class Camera(

    /**
     * Unique camera ID.
     */
    val id: String = "",

    /**
     * Camera display name.
     */
    val name: String = "",

    /**
     * Camera type.
     *
     * Examples:
     * Front
     * Back
     * External
     * USB
     */
    val type: String = "",

    /**
     * Lens facing.
     *
     * Front
     * Back
     */
    val lensFacing: String = "",

    /**
     * Resolution.
     *
     * Example:
     * 1920x1080
     * 1280x720
     */
    val resolution: String = "",

    /**
     * Frames per second.
     */
    val frameRate: Int = 30,

    /**
     * Bitrate (kbps).
     */
    val bitrate: Int = 0,

    /**
     * Zoom level.
     */
    val zoom: Float = 1f,

    /**
     * Flash enabled.
     */
    val flashEnabled: Boolean = false,

    /**
     * Auto focus enabled.
     */
    val autoFocusEnabled: Boolean = true,

    /**
     * Exposure compensation.
     */
    val exposure: Int = 0,

    /**
     * White balance mode.
     */
    val whiteBalance: String = "Auto",

    /**
     * Device orientation.
     *
     * Examples:
     * Portrait
     * Landscape
     */
    val orientation: String = "Landscape",

    /**
     * Camera status.
     *
     * Examples:
     * Available
     * In Use
     * Disabled
     * Error
     */
    val status: String = "",

    /**
     * Whether this is the active camera.
     */
    val isActive: Boolean = false,

    /**
     * Last update timestamp.
     */
    val updatedAt: Long = 0L
)
