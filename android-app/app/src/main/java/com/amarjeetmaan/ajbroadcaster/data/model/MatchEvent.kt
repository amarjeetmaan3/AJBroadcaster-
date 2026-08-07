package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents an important event during a cricket match.
 *
 * This model is used for timelines, commentary,
 * notifications, and broadcast graphics.
 */
data class MatchEvent(

    /**
     * Unique event ID.
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
     */
    val overNumber: Int = 0,

    /**
     * Ball number.
     */
    val ballNumber: Int = 0,

    /**
     * Event type.
     *
     * Examples:
     * Toss
     * Four
     * Six
     * Wicket
     * Fifty
     * Century
     * Hat Trick
     * Drinks Break
     * Innings Break
     * Match Start
     * Match End
     * Rain Delay
     */
    val eventType: String = "",

    /**
     * Event title.
     */
    val title: String = "",

    /**
     * Event description.
     */
    val description: String = "",

    /**
     * Associated player ID.
     */
    val playerId: String = "",

    /**
     * Associated team ID.
     */
    val teamId: String = "",

    /**
     * Runs involved in the event.
     */
    val runs: Int = 0,

    /**
     * Wickets involved in the event.
     */
    val wickets: Int = 0,

    /**
     * Whether the event should appear
     * in broadcast graphics.
     */
    val showOnOverlay: Boolean = true,

    /**
     * Event timestamp.
     */
    val timestamp: Long = 0L
)
