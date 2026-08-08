package com.amarjeetmaan.ajbroadcaster.cricket

import com.amarjeetmaan.ajbroadcaster.data.model.Ball

/**
 * Handles bowler statistics and bowling calculations.
 */
class BowlingManager {

    data class BowlerStats(
        val playerId: String,
        val balls: Int = 0,
        val runsConceded: Int = 0,
        val wickets: Int = 0,
        val maidens: Int = 0
    ) {
        val overs: String
            get() = "${balls / 6}.${balls % 6}"

        val economy: Double
            get() = if (balls > 0) {
                runsConceded.toDouble() * 6 / balls
            } else {
                0.0
            }
    }

    fun applyBall(
        stats: BowlerStats,
        ball: Ball
    ): BowlerStats {

        if (stats.playerId != ball.bowlerId) {
            return stats
        }

        val legal =
            ball.extraType.lowercase() != "wide"

        val bowlerRuns = when {
            ball.extraType.equals(
                "bye",
                ignoreCase = true
            ) -> 0

            ball.extraType.equals(
                "leg bye",
                ignoreCase = true
            ) -> 0

            else -> ball.totalRuns
        }

        return stats.copy(
            balls = stats.balls +
                if (legal) 1 else 0,
            runsConceded =
                stats.runsConceded + bowlerRuns,
            wickets =
                stats.wickets +
                    if (
                        ball.isWicket &&
                        isBowlerWicket(ball.wicketType)
                    ) {
                        1
                    } else {
                        0
                    }
        )
    }

    fun isBowlerWicket(
        wicketType: String
    ): Boolean {
        return when (wicketType.lowercase()) {
            "bowled",
            "lbw",
            "caught",
            "stumped",
            "hit wicket" -> true

            else -> false
        }
    }
}
