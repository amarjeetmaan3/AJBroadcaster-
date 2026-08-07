package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents a cricket match.
 *
 * This model stores match metadata and references.
 * Ball-by-ball calculations belong to the cricket engine.
 */
data class Match(

    /**
     * Unique match ID.
     */
    val id: String = "",

    /**
     * Tournament ID.
     */
    val tournamentId: String = "",

    /**
     * Match number.
     */
    val matchNumber: Int = 0,

    /**
     * Match title.
     *
     * Example:
     * Match 5
     * Semi Final
     * Final
     */
    val title: String = "",

    /**
     * Home team ID.
     */
    val teamAId: String = "",

    /**
     * Away team ID.
     */
    val teamBId: String = "",

    /**
     * Toss winner team ID.
     */
    val tossWinnerId: String = "",

    /**
     * Toss decision.
     *
     * Bat
     * Bowl
     */
    val tossDecision: String = "",

    /**
     * Current innings number.
     */
    val currentInnings: Int = 1,

    /**
     * Overs per innings.
     */
    val oversPerInnings: Int = 0,

    /**
     * Match type.
     *
     * League
     * Quarter Final
     * Semi Final
     * Final
     * Friendly
     */
    val matchType: String = "",

    /**
     * Match status.
     *
     * Scheduled
     * Toss
     * Live
     * Innings Break
     * Completed
     * Abandoned
     * Cancelled
     */
    val status: String = "",

    /**
     * Winning team ID.
     */
    val winnerTeamId: String = "",

    /**
     * Winning margin.
     *
     * Example:
     * Won by 8 Wickets
     * Won by 12 Runs
     */
    val result: String = "",

    /**
     * Venue.
     */
    val venue: String = "",

    /**
     * Match date.
     */
    val matchDate: Long = 0L,

    /**
     * Scheduled start time.
     */
    val scheduledStartTime: Long = 0L,

    /**
     * Actual start time.
     */
    val actualStartTime: Long = 0L,

    /**
     * Match end time.
     */
    val endTime: Long = 0L,

    /**
     * Umpire IDs.
     */
    val umpireIds: List<String> = emptyList(),

    /**
     * Scorer user ID.
     */
    val scorerId: String = "",

    /**
     * Live stream enabled.
     */
    val isLiveStreaming: Boolean = false,

    /**
     * Match is completed.
     */
    val isCompleted: Boolean = false,

    /**
     * Created by user ID.
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
