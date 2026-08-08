package com.amarjeetmaan.ajbroadcaster.cricket

import com.amarjeetmaan.ajbroadcaster.data.model.Ball

/**
 * Calculates match, batting and bowling statistics
 * from immutable ball records.
 */
class StatisticsManager {

    data class MatchStatistics(
        val runs: Int,
        val wickets: Int,
        val legalBalls: Int,
        val fours: Int,
        val sixes: Int,
        val extras: Int,
        val runRate: Double
    )

    fun calculate(
        balls: List<Ball>
    ): MatchStatistics {

        val runs = balls.sumOf {
            it.totalRuns
        }

        val wickets = balls.count {
            it.isWicket
        }

        val legalBalls = balls.count {
            it.extraType.lowercase() != "wide" &&
                it.extraType.lowercase() != "no ball"
        }

        val fours = balls.count {
            it.batsmanRuns == 4
        }

        val sixes = balls.count {
            it.batsmanRuns == 6
        }

        val extras = balls.sumOf {
            it.extras
        }

        val runRate = if (legalBalls > 0) {
            runs.toDouble() * 6 / legalBalls
        } else {
            0.0
        }

        return MatchStatistics(
            runs = runs,
            wickets = wickets,
            legalBalls = legalBalls,
            fours = fours,
            sixes = sixes,
            extras = extras,
            runRate = runRate
        )
    }

    fun batterRuns(
        balls: List<Ball>,
        playerId: String
    ): Int {
        return balls
            .filter { it.batterId == playerId }
            .sumOf { it.batsmanRuns }
    }

    fun bowlerWickets(
        balls: List<Ball>,
        playerId: String
    ): Int {
        return balls.count {
            it.bowlerId == playerId &&
                it.isWicket &&
                WicketManager()
                    .isBowlerCredited(it.wicketType)
        }
    }
}
