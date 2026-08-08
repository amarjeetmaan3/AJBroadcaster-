package com.amarjeetmaan.ajbroadcaster.cricket

import com.amarjeetmaan.ajbroadcaster.data.model.Ball

/**
 * Calculates batter partnership statistics.
 */
class PartnershipManager {

    data class Partnership(
        val batterOneId: String,
        val batterTwoId: String,
        val runs: Int = 0,
        val balls: Int = 0
    ) {
        val runRate: Double
            get() = if (balls > 0) {
                runs.toDouble() * 6 / balls
            } else {
                0.0
            }
    }

    fun calculate(
        balls: List<Ball>,
        batterOneId: String,
        batterTwoId: String
    ): Partnership {

        var runs = 0
        var legalBalls = 0

        balls.forEach { ball ->

            val belongsToPair =
                (
                    ball.batterId == batterOneId &&
                        ball.nonStrikerId == batterTwoId
                    ) ||
                    (
                        ball.batterId == batterTwoId &&
                            ball.nonStrikerId == batterOneId
                        )

            if (!belongsToPair) return@forEach

            runs += ball.totalRuns

            if (
                ball.extraType.lowercase() != "wide" &&
                ball.extraType.lowercase() != "no ball"
            ) {
                legalBalls++
            }
        }

        return Partnership(
            batterOneId = batterOneId,
            batterTwoId = batterTwoId,
            runs = runs,
            balls = legalBalls
        )
    }

    fun highestPartnership(
        partnerships: List<Partnership>
    ): Partnership? {
        return partnerships.maxByOrNull {
            it.runs
        }
    }
}
