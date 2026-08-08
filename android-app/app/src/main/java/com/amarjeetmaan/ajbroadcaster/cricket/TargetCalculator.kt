package com.amarjeetmaan.ajbroadcaster.cricket

/**
 * Performs target and run-rate calculations.
 */
class TargetCalculator {

    fun calculateTarget(
        firstInningsRuns: Int
    ): Int {
        return firstInningsRuns
            .coerceAtLeast(0) + 1
    }

    fun calculateRunsRequired(
        target: Int,
        currentRuns: Int
    ): Int {
        return (
            target.coerceAtLeast(0) -
                currentRuns.coerceAtLeast(0)
            ).coerceAtLeast(0)
    }

    fun calculateRunRate(
        runs: Int,
        legalBalls: Int
    ): Double {
        if (legalBalls <= 0) {
            return 0.0
        }

        return runs.coerceAtLeast(0).toDouble() *
            6 /
            legalBalls
    }

    fun calculateRequiredRunRate(
        target: Int,
        currentRuns: Int,
        ballsRemaining: Int
    ): Double {

        if (ballsRemaining <= 0) {
            return 0.0
        }

        val required =
            calculateRunsRequired(
                target = target,
                currentRuns = currentRuns
            )

        return required.toDouble() *
            6 /
            ballsRemaining
    }

    fun calculateBallsRemaining(
        totalOvers: Int,
        legalBallsBowled: Int
    ): Int {

        val totalBalls =
            totalOvers.coerceAtLeast(0) * 6

        return (
            totalBalls -
                legalBallsBowled.coerceAtLeast(0)
            ).coerceAtLeast(0)
    }

    fun isTargetReached(
        target: Int,
        currentRuns: Int
    ): Boolean {
        return currentRuns >= target &&
            target > 0
    }
}
