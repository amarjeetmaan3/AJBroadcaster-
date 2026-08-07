package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents broadcast graphics configuration.
 *
 * This model stores graphics settings only.
 * Rendering and animation are handled by the graphics engine.
 */
data class Graphics(

    /**
     * Unique graphics profile ID.
     */
    val id: String = "",

    /**
     * Graphics profile name.
     */
    val name: String = "",

    /**
     * Theme name.
     */
    val theme: String = "",

    /**
     * Primary color.
     */
    val primaryColor: String = "",

    /**
     * Secondary color.
     */
    val secondaryColor: String = "",

    /**
     * Accent color.
     */
    val accentColor: String = "",

    /**
     * Team logo display enabled.
     */
    val showTeamLogos: Boolean = true,

    /**
     * Sponsor banner enabled.
     */
    val showSponsorBanner: Boolean = true,

    /**
     * Watermark enabled.
     */
    val showWatermark: Boolean = true,

    /**
     * Animation enabled.
     */
    val animationsEnabled: Boolean = true,

    /**
     * Score overlay enabled.
     */
    val showScoreOverlay: Boolean = true,

    /**
     * Player statistics enabled.
     */
    val showPlayerStats: Boolean = true,

    /**
     * Match summary enabled.
     */
    val showMatchSummary: Boolean = true,

    /**
     * Overlay opacity.
     *
     * Range:
     * 0.0 - 1.0
     */
    val overlayOpacity: Float = 1f,

    /**
     * Graphics status.
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
