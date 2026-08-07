package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents a sponsor used in tournaments,
 * matches, and broadcast graphics.
 */
data class Sponsor(

    /**
     * Unique sponsor ID.
     */
    val id: String = "",

    /**
     * Sponsor name.
     */
    val name: String = "",

    /**
     * Sponsor category.
     *
     * Examples:
     * Title Sponsor
     * Powered By
     * Co-Sponsor
     * Partner
     * Advertisement
     */
    val category: String = "",

    /**
     * Sponsor logo URL.
     */
    val logoUrl: String = "",

    /**
     * Sponsor banner URL.
     */
    val bannerUrl: String = "",

    /**
     * Website URL.
     */
    val website: String = "",

    /**
     * Contact person.
     */
    val contactPerson: String = "",

    /**
     * Contact number.
     */
    val contactNumber: String = "",

    /**
     * Email address.
     */
    val email: String = "",

    /**
     * Display priority.
     *
     * Lower value = Higher priority.
     */
    val priority: Int = 0,

    /**
     * Whether sponsor is active.
     */
    val isActive: Boolean = true,

    /**
     * Display locations.
     *
     * Examples:
     * Scoreboard
     * Toss Screen
     * Boundary Graphic
     * Wicket Graphic
     * Match Summary
     */
    val displayLocations: List<String> = emptyList(),

    /**
     * Tournament ID.
     */
    val tournamentId: String = "",

    /**
     * Creation timestamp.
     */
    val createdAt: Long = 0L,

    /**
     * Last update timestamp.
     */
    val updatedAt: Long = 0L
)
