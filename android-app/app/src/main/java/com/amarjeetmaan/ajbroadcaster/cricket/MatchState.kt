package com.amarjeetmaan.ajbroadcaster.cricket

import com.amarjeetmaan.ajbroadcaster.data.model.Ball
import com.amarjeetmaan.ajbroadcaster.data.model.Innings
import com.amarjeetmaan.ajbroadcaster.data.model.Match
import com.amarjeetmaan.ajbroadcaster.data.model.Over

/**
 * Complete in-memory state of a live match.
 *
 * This is the central state passed between cricket-engine
 * components.
 */
data class MatchState(
    val match: Match,
    val innings: List<Innings> = emptyList(),
    val balls: List<Ball> = emptyList(),
    val overs: List<Over> = emptyList()
) {

    val currentInnings: Innings?
        get() = innings.lastOrNull()

    val currentScoreRuns: Int
        get() = currentInnings?.runs ?: 0

    val currentWickets: Int
        get() = currentInnings?.wickets ?: 0

    val currentLegalBalls: Int
        get() = currentInnings?.totalBalls ?: 0

    val currentOvers: String
        get() {
            val balls = currentLegalBalls
            return "${balls / 6}.${balls % 6}"
        }
}
