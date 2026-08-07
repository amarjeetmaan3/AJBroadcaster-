package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents a single innings of a cricket match.
 *
 * This model stores innings metadata only.
 * Ball-by-ball calculations belong to the cricket engine.
 */
data class Innings(

    /**
     * Unique innings ID.
     */
    val id: String = "",

    /**
     * Match ID.
     */
    val matchId: String = "",

    /**
     * Innings number.
     */
    val inningsNumber: Int = 1,

    /**
     * Batting team ID.
     */
    val battingTeamId: String = "",

    /**
     * Bowling team ID.
     */
    val bowlingTeamId: String = "",

    /**
     * Total runs.
     */
    val runs: Int = 0,

    /**
     * Total wickets.
     */
    val wickets: Int = 0,

    /**
     * Completed overs.
     */
    val completedOvers: Int = 0,

    /**
     * Balls in current over.
     */
    val balls: Int = 0,

    /**
     * Total legal balls bowled.
     */
    val totalBalls: Int = 0,

    /**
     * Total extras.
     */
    val extras: Int = 0,

    /**
     * Target score.
     *
     * Used mainly in the second innings.
     */
    val target: Int = 0,

    /**
     * Current striker player ID.
     */
    val strikerId: String = "",

    /**
     * Current non-striker player ID.
     */
    val nonStrikerId: String = "",

    /**
     * Current bowler player ID.
     */
    val currentBowlerId: String = "",

    /**
     * Innings status.
     *
     * Examples:
     * Not Started
     * Live
     * Completed
     * Declared
     */
    val status: String = "",

    /**
     * Innings start time.
     */
    val startTime: Long = 0L,

    /**
     * Innings end time.
     */
    val endTime: Long = 0L,

    /**
     * Creation timestamp.
     */
    val createdAt: Long = 0L,

    /**
     * Last update timestamp.
     */
    val updatedAt: Long = 0L
)
