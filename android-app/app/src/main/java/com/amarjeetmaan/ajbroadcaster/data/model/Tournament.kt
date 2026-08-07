package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents a cricket tournament.
 *
 * This model contains tournament metadata only.
 * Match logic and calculations belong to the cricket engine.
 */
data class Tournament(

    /**
     * Unique tournament ID.
     */
    val id: String = "",

    /**
     * Tournament name.
     */
    val name: String = "",

    /**
     * Tournament description.
     */
    val description: String = "",

    /**
     * Tournament logo URL.
     */
    val logoUrl: String = "",

    /**
     * Tournament location.
     */
    val location: String = "",

    /**
     * Organizer name.
     */
    val organizer: String = "",

    /**
     * Contact number.
     */
    val contactNumber: String = "",

    /**
     * Tournament format.
     *
     * Examples:
     * T10
     * T20
     * ODI
     * Test
     * Custom
     */
    val format: String = "",

    /**
     * Overs per innings.
     */
    val oversPerInnings: Int = 0,

    /**
     * Maximum teams.
     */
    val totalTeams: Int = 0,

    /**
     * Registered teams.
     */
    val registeredTeams: Int = 0,

    /**
     * Tournament status.
     *
     * Examples:
     * Upcoming
     * Registration
     * Live
     * Completed
     * Cancelled
     */
    val status: String = "",

    /**
     * Tournament start date.
     */
    val startDate: Long = 0L,

    /**
     * Tournament end date.
     */
    val endDate: Long = 0L,

    /**
     * Winner prize amount.
     */
    val winnerPrize: Double = 0.0,

    /**
     * Runner-up prize amount.
     */
    val runnerUpPrize: Double = 0.0,

    /**
     * Entry fee per team.
     */
    val entryFee: Double = 0.0,

    /**
     * Tournament banner URL.
     */
    val bannerUrl: String = "",

    /**
     * Whether registration is open.
     */
    val registrationOpen: Boolean = false,

    /**
     * Tournament creator user ID.
     */
    val createdBy: String = "",

    /**
     * Creation timestamp.
     */
    val createdAt: Long = 0L,

    /**
     * Last update timestamp.
     */
    val updatedAt: Long = 0L
)
