package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents a single over in a cricket innings.
 *
 * This model stores over metadata only.
 * Individual deliveries are stored in Ball.kt.
 */
data class Over(

    /**
     * Unique over ID.
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
     * Over number.
     *
     * First over = 1
     */
    val overNumber: Int = 1,

    /**
     * Bowler player ID.
     */
    val bowlerId: String = "",

    /**
     * Total legal balls.
     */
    val legalBalls: Int = 0,

    /**
     * Total runs scored in this over.
     */
    val runs: Int = 0,

    /**
     * Total wickets in this over.
     */
    val wickets: Int = 0,

    /**
     * Total extras in this over.
     */
    val extras: Int = 0,

    /**
     * Ball IDs belonging to this over.
     */
    val ballIds: List<String> = emptyList(),

    /**
     * Whether the over is completed.
     */
    val isCompleted: Boolean = false,

    /**
     * Over start time.
     */
    val startTime: Long = 0L,

    /**
     * Over end time.
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
