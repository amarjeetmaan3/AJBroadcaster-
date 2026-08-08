package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class ScoreSummary(
    val teamName: String = "Team A",
    val runs: Int = 125,
    val wickets: Int = 4,
    val balls: Int = 90,
    val target: Int = 180
) {
    val overs: String
        get() = "${balls / 6}.${balls % 6}"

    val runRate: String
        get() = if (balls > 0) {
            "%.2f".format(
                runs.toDouble() * 6 / balls
            )
        } else {
            "0.00"
        }

    val requiredRuns: Int
        get() = (target - runs).coerceAtLeast(0)
}

@HiltViewModel
class ScoreSummaryViewModel @Inject constructor() : ViewModel() {

    private val _summary = MutableStateFlow(
        ScoreSummary()
    )

    val summary: StateFlow<ScoreSummary>
        get() = _summary

    fun update(
        teamName: String,
        runs: Int,
        wickets: Int,
        balls: Int,
        target: Int
    ) {
        _summary.value = ScoreSummary(
            teamName = teamName.trim(),
            runs = runs.coerceAtLeast(0),
            wickets = wickets.coerceIn(0, 10),
            balls = balls.coerceAtLeast(0),
            target = target.coerceAtLeast(0)
        )
    }

    fun reset() {
        _summary.value = ScoreSummary(
            teamName = "",
            runs = 0,
            wickets = 0,
            balls = 0,
            target = 0
        )
    }
}
