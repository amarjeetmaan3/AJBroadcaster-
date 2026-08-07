package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents the live scoreboard of a cricket match.
 *
 * This model is optimized for displaying live score overlays,
 * scorecards, and broadcast graphics.
 */
data class Score(

    /**
     * Match ID.
     */
    val matchId: String = "",

    /**
     * Innings ID.
     */
    val inningsId: String = "",

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
    val overs: Int = 0,

    /**
     * Balls in current over.
     */
    val balls: Int = 0,

    /**
     * Current Run Rate.
     */
    val currentRunRate: Double = 0.0,

    /**
     * Required Run Rate.
     */
    val requiredRunRate: Double = 0.0,

    /**
     * Target score.
     */
    val target: Int = 0,

    /**
     * Runs required to win.
     */
    val runsRequired: Int = 0,

    /**
     * Balls remaining.
     */
    val ballsRemaining: Int = 0,

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
    val bowlerId: String = "",

    /**
     * Match status.
     */
    val matchStatus: String = "",

    /**
     * Last updated timestamp.
     */
    val updatedAt: Long = 0L
)
