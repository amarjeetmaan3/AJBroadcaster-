package com.amarjeetmaan.ajbroadcaster.cricket

import com.amarjeetmaan.ajbroadcaster.data.model.Ball
import com.amarjeetmaan.ajbroadcaster.data.model.Over

/**
 * Manages over-level calculations.
 */
class OverManager {

    fun createOver(
        matchId: String,
        inningsId: String,
        overNumber: Int,
        bowlerId: String
    ): Over {

        val now = System.currentTimeMillis()

        return Over(
            id = "$inningsId-over-$overNumber",
            matchId = matchId,
            inningsId = inningsId,
            overNumber = overNumber,
            bowlerId = bowlerId,
            startTime = now,
            createdAt = now,
            updatedAt = now
        )
    }

    fun addBall(
        over: Over,
        ball: Ball
    ): Over {

        val legalBall =
            ball.extraType.lowercase() != "wide"

        val legalBalls =
            over.legalBalls +
                if (legalBall) 1 else 0

        return over.copy(
            legalBalls = legalBalls,
            runs = over.runs + ball.totalRuns,
            wickets =
                over.wickets +
                    if (ball.isWicket) 1 else 0,
            extras = over.extras + ball.extras,
            ballIds = over.ballIds + ball.id,
            isCompleted = legalBalls >= 6,
            endTime =
                if (legalBalls >= 6) {
                    System.currentTimeMillis()
                } else {
                    over.endTime
                },
            updatedAt = System.currentTimeMillis()
        )
    }

    fun isComplete(over: Over): Boolean {
        return over.legalBalls >= 6
    }

    fun calculateRunRate(over: Over): Double {
        return over.runs.toDouble()
    }
}
