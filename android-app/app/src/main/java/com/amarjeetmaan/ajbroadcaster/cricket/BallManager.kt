package com.amarjeetmaan.ajbroadcaster.cricket

import com.amarjeetmaan.ajbroadcaster.data.model.Ball

/**
 * Creates and validates delivery records.
 */
class BallManager {

    fun createBall(
        matchId: String,
        inningsId: String,
        overId: String,
        overNumber: Int,
        ballNumber: Int,
        batterId: String,
        nonStrikerId: String,
        bowlerId: String,
        batsmanRuns: Int = 0,
        extras: Int = 0,
        extraType: String = "",
        wicket: Boolean = false,
        wicketType: String = "",
        outPlayerId: String = "",
        fielderId: String = ""
    ): Ball {

        val safeBatRuns = batsmanRuns.coerceAtLeast(0)
        val safeExtras = extras.coerceAtLeast(0)

        return Ball(
            id = createId(),
            matchId = matchId,
            inningsId = inningsId,
            overId = overId,
            overNumber = overNumber,
            ballNumber = ballNumber,
            batterId = batterId,
            nonStrikerId = nonStrikerId,
            bowlerId = bowlerId,
            batsmanRuns = safeBatRuns,
            extras = safeExtras,
            totalRuns = safeBatRuns + safeExtras,
            extraType = extraType,
            isWicket = wicket,
            wicketType = wicketType,
            outPlayerId = outPlayerId,
            fielderId = fielderId,
            timestamp = System.currentTimeMillis()
        )
    }

    fun isLegal(ball: Ball): Boolean {
        return ball.extraType.lowercase() != "wide"
    }

    fun isBoundary(ball: Ball): Boolean {
        return ball.batsmanRuns == 4 ||
            ball.batsmanRuns == 6
    }

    fun isFour(ball: Ball): Boolean {
        return ball.batsmanRuns == 4
    }

    fun isSix(ball: Ball): Boolean {
        return ball.batsmanRuns == 6
    }

    private fun createId(): String {
        return "ball-${System.currentTimeMillis()}-${hashCode()}"
    }
}
