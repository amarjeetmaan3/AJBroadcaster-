package com.amarjeetmaan.ajbroadcaster.cricket

import com.amarjeetmaan.ajbroadcaster.data.model.Ball
import com.amarjeetmaan.ajbroadcaster.data.model.Match

/**
 * Main entry point for the cricket engine.
 *
 * UI, Firebase and broadcasting modules should communicate
 * with cricket scoring through this class rather than
 * implementing cricket rules themselves.
 */
class CricketManager {

    private val matchEngine = MatchEngine()
    private val scoreEngine = ScoreEngine()
    private val inningsManager = InningsManager()
    private val overManager = OverManager()
    private val ballManager = BallManager()
    private val battingManager = BattingManager()
    private val bowlingManager = BowlingManager()
    private val extrasManager = ExtrasManager()
    private val wicketManager = WicketManager()
    private val partnershipManager = PartnershipManager()
    private val statisticsManager = StatisticsManager()
    private val targetCalculator = TargetCalculator()
    private val undoManager = UndoManager()

    fun startMatch(match: Match): MatchState {
        undoManager.clear()

        val state = matchEngine.initialize(match)

        undoManager.record(state)

        return state
    }

    fun addBall(
        state: MatchState,
        ball: Ball
    ): MatchState {
        undoManager.record(state)

        val updated = scoreEngine.applyBall(
            state = state,
            ball = ball
        )

        return updated
    }

    fun undo(
        currentState: MatchState
    ): MatchState? {
        return undoManager.undo(currentState)
    }

    fun redo(
        currentState: MatchState
    ): MatchState? {
        return undoManager.redo(currentState)
    }

    fun calculateTarget(
        firstInningsRuns: Int
    ): Int {
        return targetCalculator.calculateTarget(firstInningsRuns)
    }

    fun currentRunRate(
        runs: Int,
        legalBalls: Int
    ): Double {
        return targetCalculator.calculateRunRate(
            runs = runs,
            legalBalls = legalBalls
        )
    }

    fun requiredRunRate(
        target: Int,
        currentRuns: Int,
        ballsRemaining: Int
    ): Double {
        return targetCalculator.calculateRequiredRunRate(
            target = target,
            currentRuns = currentRuns,
            ballsRemaining = ballsRemaining
        )
    }

    fun getMatchEngine(): MatchEngine = matchEngine

    fun getInningsManager(): InningsManager = inningsManager

    fun getOverManager(): OverManager = overManager

    fun getBallManager(): BallManager = ballManager

    fun getBattingManager(): BattingManager = battingManager

    fun getBowlingManager(): BowlingManager = bowlingManager

    fun getExtrasManager(): ExtrasManager = extrasManager

    fun getWicketManager(): WicketManager = wicketManager

    fun getPartnershipManager(): PartnershipManager = partnershipManager

    fun getStatisticsManager(): StatisticsManager = statisticsManager
}
