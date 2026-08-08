package com.amarjeetmaan.ajbroadcaster.cricket

import com.amarjeetmaan.ajbroadcaster.data.model.Innings

/**
 * Handles innings lifecycle and innings-level calculations.
 */
class InningsManager {

    fun create(
        matchId: String,
        inningsNumber: Int,
        battingTeamId: String,
        bowlingTeamId: String
    ): Innings {

        val now = System.currentTimeMillis()

        return Innings(
            id = "$matchId-innings-$inningsNumber",
            matchId = matchId,
            inningsNumber = inningsNumber,
            battingTeamId = battingTeamId,
            bowlingTeamId = bowlingTeamId,
            status = "Live",
            startTime = now,
            createdAt = now,
            updatedAt = now
        )
    }

    fun complete(
        innings: Innings,
        status: String = "Completed"
    ): Innings {

        val now = System.currentTimeMillis()

        return innings.copy(
            status = status,
            endTime = now,
            updatedAt = now
        )
    }

    fun setTarget(
        innings: Innings,
        target: Int
    ): Innings {
        return innings.copy(
            target = target.coerceAtLeast(0),
            updatedAt = System.currentTimeMillis()
        )
    }

    fun setPlayers(
        innings: Innings,
        strikerId: String,
        nonStrikerId: String,
        bowlerId: String
    ): Innings {
        return innings.copy(
            strikerId = strikerId,
            nonStrikerId = nonStrikerId,
            currentBowlerId = bowlerId,
            updatedAt = System.currentTimeMillis()
        )
    }
}
