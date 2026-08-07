package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents a single delivery in a cricket match.
 *
 * Every legal and illegal delivery is stored as a Ball.
 * This model is the foundation of scoring, statistics,
 * graphics, and match history.
 */
data class Ball(

    /**
     * Unique ball ID.
     */
    val id: String = "",

    /**
     * Match ID.
     */
    val matchId: String = "",

    /**
     * Innings ID.
     */
    val inningsId: String = "",

    /**
     * Over ID.
     */
    val overId: String = "",

    /**
     * Over number.
     */
    val overNumber: Int = 0,

    /**
     * Ball number within the over.
     *
     * Legal deliveries:
     * 1–6
     */
    val ballNumber: Int = 0,

    /**
     * Batter player ID.
     */
    val batterId: String = "",

    /**
     * Non-striker player ID.
     */
    val nonStrikerId: String = "",

    /**
     * Bowler player ID.
     */
    val bowlerId: String = "",

    /**
     * Runs scored from the bat.
     */
    val batsmanRuns: Int = 0,

    /**
     * Extra runs.
     */
    val extras: Int = 0,

    /**
     * Total runs on this delivery.
     */
    val totalRuns: Int = 0,

    /**
     * Extra type.
     *
     * Examples:
     * None
     * Wide
     * No Ball
     * Bye
     * Leg Bye
     */
    val extraType: String = "",

    /**
     * Whether a wicket fell.
     */
    val isWicket: Boolean = false,

    /**
     * Wicket type.
     *
     * Examples:
     * Bowled
     * Caught
     * LBW
     * Run Out
     * Stumped
     * Hit Wicket
     */
    val wicketType: String = "",

    /**
     * Out batter player ID.
     */
    val outPlayerId: String = "",

    /**
     * Fielder player ID.
     */
    val fielderId: String = "",

    /**
     * Free hit delivery.
     */
    val isFreeHit: Boolean = false,

    /**
     * Review taken.
     */
    val isReview: Boolean = false,

    /**
     * Ball timestamp.
     */
    val timestamp: Long = 0L
)
