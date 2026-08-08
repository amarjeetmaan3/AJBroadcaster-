package com.amarjeetmaan.ajbroadcaster.cricket

import com.amarjeetmaan.ajbroadcaster.data.model.Innings
import com.amarjeetmaan.ajbroadcaster.data.model.Match

/**
 * Controls match-level lifecycle.
 */
class MatchEngine {

    fun initialize(match: Match): MatchState {
        val now = System.currentTimeMillis()

        val updatedMatch = match.copy(
            status = "Live",
            actualStartTime = now,
            updatedAt = now
        )

        return MatchState(
            match = updatedMatch,
            innings = emptyList(),
            balls = emptyList(),
            overs = emptyList()
        )
    }

    fun createInnings(
        state: MatchState,
        inningsNumber: Int,
        battingTeamId: String,
        bowlingTeamId: String
    ): MatchState {

        val innings = Innings(
            id = "${state.match.id}-innings-$inningsNumber",
            matchId = state.match.id,
            inningsNumber = inningsNumber,
            battingTeamId = battingTeamId,
            bowlingTeamId = bowlingTeamId,
            status = "Live",
            startTime = System.currentTimeMillis(),
            createdAt = System.currentTimeMillis()
        )

        return state.copy(
            innings = state.innings + innings,
            match = state.match.copy(
                currentInnings = inningsNumber,
                status = "Live",
                updatedAt = System.currentTimeMillis()
            )
        )
    }

    fun completeMatch(
        state: MatchState,
        winnerTeamId: String,
        result: String
    ): MatchState {

        val now = System.currentTimeMillis()

        return state.copy(
            match = state.match.copy(
                status = "Completed",
                winnerTeamId = winnerTeamId,
                result = result,
                isCompleted = true,
                endTime = now,
                updatedAt = now
            )
        )
    }

    fun reset(state: MatchState): MatchState {
        return initialize(
            state.match.copy(
                status = "Scheduled",
                currentInnings = 1,
                winnerTeamId = "",
                result = "",
                isCompleted = false,
                actualStartTime = 0L,
                endTime = 0L
            )
        )
    }
}
