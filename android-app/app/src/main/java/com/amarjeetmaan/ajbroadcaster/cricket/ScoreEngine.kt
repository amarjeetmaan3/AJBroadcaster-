package com.amarjeetmaan.ajbroadcaster.cricket

import com.amarjeetmaan.ajbroadcaster.data.model.Ball
import com.amarjeetmaan.ajbroadcaster.data.model.Innings
import com.amarjeetmaan.ajbroadcaster.data.model.Over

/**
 * Applies a delivery to the current match state.
 *
 * This class contains the central score calculation.
 */
class ScoreEngine {

    fun applyBall(
        state: MatchState,
        ball: Ball
    ): MatchState {

        val current = state.currentInnings
            ?: return state

        val legalBall = isLegalDelivery(ball)

        val updatedRuns =
            current.runs + ball.totalRuns

        val updatedWickets =
            current.wickets +
                if (ball.isWicket) 1 else 0

        val updatedTotalBalls =
            current.totalBalls +
                if (legalBall) 1 else 0

        val updatedExtras =
            current.extras + ball.extras

        val updatedInnings = current.copy(
            runs = updatedRuns,
            wickets = updatedWickets,
            balls = updatedTotalBalls % 6,
            completedOvers = updatedTotalBalls / 6,
            totalBalls = updatedTotalBalls,
            extras = updatedExtras,
            strikerId = ball.nonStrikerId,
            nonStrikerId = ball.batterId,
            updatedAt = System.currentTimeMillis()
        )

        val inningsList = state.innings.dropLast(1) +
            updatedInnings

        val updatedOver = updateOver(
            state = state,
            ball = ball,
            legalBall = legalBall
        )

        return state.copy(
            innings = inningsList,
            balls = state.balls + ball,
            overs = updatedOver
        )
    }

    private fun isLegalDelivery(ball: Ball): Boolean {
        return ball.extraType.lowercase() != "wide"
    }

    private fun updateOver(
        state: MatchState,
        ball: Ball,
        legalBall: Boolean
    ): List<Over> {

        val currentOverNumber =
            state.currentInnings?.completedOvers?.plus(1) ?: 1

        val existing =
            state.overs.lastOrNull()

        if (
            existing == null ||
            existing.overNumber != currentOverNumber
        ) {
            return state.overs + Over(
                id = "${ball.inningsId}-over-$currentOverNumber",
                matchId = ball.matchId,
                inningsId = ball.inningsId,
                overNumber = currentOverNumber,
                bowlerId = ball.bowlerId,
                legalBalls = if (legalBall) 1 else 0,
                runs = ball.totalRuns,
                wickets = if (ball.isWicket) 1 else 0,
                extras = ball.extras,
                ballIds = listOf(ball.id),
                isCompleted = legalBall
                        && ball.ballNumber >= 6,
                startTime = System.currentTimeMillis(),
                createdAt = System.currentTimeMillis(),
                updatedAt = System.currentTimeMillis()
            )
        }

        val updated = existing.copy(
            legalBalls =
                existing.legalBalls +
                    if (legalBall) 1 else 0,
            runs = existing.runs + ball.totalRuns,
            wickets =
                existing.wickets +
                    if (ball.isWicket) 1 else 0,
            extras = existing.extras + ball.extras,
            ballIds = existing.ballIds + ball.id,
            isCompleted =
                existing.legalBalls +
                    if (legalBall) 1 else 0 >= 6,
            updatedAt = System.currentTimeMillis()
        )

        return state.overs.dropLast(1) + updated
    }
}
