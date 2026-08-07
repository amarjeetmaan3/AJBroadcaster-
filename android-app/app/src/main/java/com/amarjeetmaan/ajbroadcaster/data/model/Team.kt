package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents a cricket team.
 *
 * This model stores team information only.
 * Match calculations and statistics belong to the cricket engine.
 */
data class Team(

    /**
     * Unique team ID.
     */
    val id: String = "",

    /**
     * Team name.
     */
    val name: String = "",

    /**
     * Team short name.
     *
     * Examples:
     * CSK
     * MI
     * RCB
     */
    val shortName: String = "",

    /**
     * Team logo URL.
     */
    val logoUrl: String = "",

    /**
     * Team primary color.
     *
     * Stored as Hex Color.
     * Example:
     * #FFCC00
     */
    val primaryColor: String = "",

    /**
     * Team secondary color.
     */
    val secondaryColor: String = "",

    /**
     * Captain Player ID.
     */
    val captainId: String = "",

    /**
     * Vice Captain Player ID.
     */
    val viceCaptainId: String = "",

    /**
     * Coach name.
     */
    val coach: String = "",

    /**
     * Owner name.
     */
    val owner: String = "",

    /**
     * Home location.
     */
    val location: String = "",

    /**
     * Tournament ID.
     */
    val tournamentId: String = "",

    /**
     * Player IDs belonging to this team.
     */
    val playerIds: List<String> = emptyList(),

    /**
     * Number of matches played.
     */
    val matchesPlayed: Int = 0,

    /**
     * Matches won.
     */
    val matchesWon: Int = 0,

    /**
     * Matches lost.
     */
    val matchesLost: Int = 0,

    /**
     * Matches tied.
     */
    val matchesTied: Int = 0,

    /**
     * No Result matches.
     */
    val noResult: Int = 0,

    /**
     * Tournament points.
     */
    val points: Int = 0,

    /**
     * Net Run Rate.
     */
    val netRunRate: Double = 0.0,

    /**
     * Team status.
     *
     * Examples:
     * Active
     * Eliminated
     * Qualified
     */
    val status: String = "",

    /**
     * Team creator ID.
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
