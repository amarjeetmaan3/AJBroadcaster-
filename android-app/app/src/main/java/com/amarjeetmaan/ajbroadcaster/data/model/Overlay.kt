package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents a broadcast overlay element.
 *
 * This model defines how an overlay should appear.
 * Rendering is handled by the graphics engine.
 */
data class Overlay(

    /**
     * Unique overlay ID.
     */
    val id: String = "",

    /**
     * Overlay name.
     */
    val name: String = "",

    /**
     * Overlay type.
     *
     * Examples:
     * Scoreboard
     * Batting Card
     * Bowling Card
     * Match Summary
     * Sponsor Banner
     * Fall Of Wickets
     * Manhattan
     * Wagon Wheel
     */
    val type: String = "",

    /**
     * Whether the overlay is visible.
     */
    val isVisible: Boolean = false,

    /**
     * Horizontal position.
     */
    val positionX: Float = 0f,

    /**
     * Vertical position.
     */
    val positionY: Float = 0f,

    /**
     * Overlay width.
     */
    val width: Float = 0f,

    /**
     * Overlay height.
     */
    val height: Float = 0f,

    /**
     * Overlay opacity.
     *
     * Range:
     * 0.0 - 1.0
     */
    val opacity: Float = 1f,

    /**
     * Animation name.
     *
     * Examples:
     * Fade
     * Slide
     * Zoom
     * None
     */
    val animation: String = "None",

    /**
     * Display duration (milliseconds).
     */
    val duration: Long = 0L,

    /**
     * Display order.
     */
    val zIndex: Int = 0,

    /**
     * Overlay status.
     *
     * Examples:
     * Active
     * Hidden
     * Disabled
     */
    val status: String = "",

    /**
     * Last update timestamp.
     */
    val updatedAt: Long = 0L
)
