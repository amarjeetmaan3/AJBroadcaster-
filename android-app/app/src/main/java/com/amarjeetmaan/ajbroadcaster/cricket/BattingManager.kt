package com.amarjeetmaan.ajbroadcaster.cricket

import com.amarjeetmaan.ajbroadcaster.data.model.Ball

/**
 * Handles batter-specific calculations.
 */
class BattingManager {

    data class BatterStats(
        val playerId: String,
        val runs: Int = 0,
        val balls: Int = 0,
        val fours: Int = 0,
        val sixes: Int = 0,
        val isOut: Boolean = false
    ) {
        val strikeRate: Double
            get() = if (balls > 0) {
                runs.toDouble() * 100 / balls
            } else {
                0.0
            }
    }

    fun applyBall(
        stats: BatterStats,
        ball: Ball
    ): BatterStats {

        if (stats.playerId != ball.batterId) {
            return stats
        }

        val legalBall =
            ball.extraType.lowercase() != "wide"

        return stats.copy(
            runs = stats.runs + ball.batsmanRuns,
            balls = stats.balls +
                if (legalBall) 1 else 0,
            fours = stats.fours +
                if (ball.batsmanRuns == 4) 1 else 0,
            sixes = stats.sixes +
                if (ball.batsmanRuns == 6) 1 else 0,
            isOut = stats.isOut || ball.isWicket
        )
    }

    fun shouldRotateStrike(
        batsmanRuns: Int
    ): Boolean {
        return batsmanRuns % 2 == 1
    }

    fun milestone(
        runs: Int
    ): Int? {
        return when {
            runs >= 100 && runs % 100 == 0 -> 100
            runs >= 50 && runs % 50 == 0 -> 50
            runs >= 25 && runs % 25 == 0 -> 25
            else -> null
        }
    }
}
