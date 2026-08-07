package com.amarjeetmaan.ajbroadcaster.data.model

/**
 * Represents statistical data for a player,
 * team, match, or tournament.
 *
 * This model stores calculated statistics.
 * Calculations are performed by the cricket engine.
 */
data class Statistics(

    /**
     * Unique statistics ID.
     */
    val id: String = "",

    /**
     * Match ID.
     */
    val matchId: String = "",

    /**
     * Tournament ID.
     */
    val tournamentId: String = "",

    /**
     * Team ID.
     */
    val teamId: String = "",

    /**
     * Player ID.
     */
    val playerId: String = "",

    /**
     * Matches played.
     */
    val matches: Int = 0,

    /**
     * Total runs scored.
     */
    val runs: Int = 0,

    /**
     * Balls faced.
     */
    val ballsFaced: Int = 0,

    /**
     * Batting average.
     */
    val battingAverage: Double = 0.0,

    /**
     * Strike rate.
     */
    val strikeRate: Double = 0.0,

    /**
     * Highest score.
     */
    val highestScore: Int = 0,

    /**
     * Fifties scored.
     */
    val fifties: Int = 0,

    /**
     * Centuries scored.
     */
    val centuries: Int = 0,

    /**
     * Wickets taken.
     */
    val wickets: Int = 0,

    /**
     * Overs bowled.
     */
    val oversBowled: Double = 0.0,

    /**
     * Runs conceded.
     */
    val runsConceded: Int = 0,

    /**
     * Bowling average.
     */
    val bowlingAverage: Double = 0.0,

    /**
     * Economy rate.
     */
    val economy: Double = 0.0,

    /**
     * Best bowling figures.
     *
     * Example:
     * 5/18
     */
    val bestBowling: String = "",

    /**
     * Catches taken.
     */
    val catches: Int = 0,

    /**
     * Run outs.
     */
    val runOuts: Int = 0,

    /**
     * Stumpings.
     */
    val stumpings: Int = 0,

    /**
     * Last update timestamp.
     */
    val updatedAt: Long = 0L
)
