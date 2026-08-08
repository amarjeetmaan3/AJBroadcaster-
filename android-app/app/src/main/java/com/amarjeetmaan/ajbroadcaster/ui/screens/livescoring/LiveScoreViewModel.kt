package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class LiveScore(
    val battingTeam: String,
    val runs: Int,
    val wickets: Int,
    val overs: String,
    val runRate: String,
    val target: Int,
    val requiredRuns: Int
)

@HiltViewModel
class LiveScoreViewModel @Inject constructor() : ViewModel() {

    private val _score = MutableStateFlow(
        LiveScore(
            battingTeam = "CSK",
            runs = 80,
            wickets = 3,
            overs = "10.3",
            runRate = "7.62",
            target = 126,
            requiredRuns = 46
        )
    )

    val score: StateFlow<LiveScore>
        get() = _score

    fun updateScore(
        battingTeam: String,
        runs: Int,
        wickets: Int,
        overs: String,
        target: Int
    ) {
        val requiredRuns =
            (target - runs).coerceAtLeast(0)

        val balls = oversToBalls(overs)

        val runRate =
            if (balls > 0) {
                "%.2f".format(
                    runs.toDouble() * 6 / balls
                )
            } else {
                "0.00"
            }

        _score.value = LiveScore(
            battingTeam = battingTeam,
            runs = runs.coerceAtLeast(0),
            wickets = wickets.coerceAtLeast(0),
            overs = overs,
            runRate = runRate,
            target = target.coerceAtLeast(0),
            requiredRuns = requiredRuns
        )
    }

    private fun oversToBalls(overs: String): Int {
        val parts = overs.split(".")

        if (parts.size != 2) {
            return 0
        }

        val completedOvers =
            parts[0].toIntOrNull() ?: return 0

        val balls =
            parts[1].toIntOrNull() ?: return 0

        if (balls !in 0..5) {
            return 0
        }

        return completedOvers * 6 + balls
    }
}
