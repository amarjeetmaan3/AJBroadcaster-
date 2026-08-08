package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class InningsSummary(
    val teamName: String = "CSK",
    val runs: Int = 125,
    val wickets: Int = 4,
    val balls: Int = 93,
    val overs: String = "15.3",
    val runRate: String = "8.06",
    val fours: Int = 11,
    val sixes: Int = 5,
    val extras: Int = 9
)

@HiltViewModel
class InningsSummaryViewModel @Inject constructor() : ViewModel() {

    private val _summary = MutableStateFlow(
        InningsSummary()
    )

    val summary: StateFlow<InningsSummary>
        get() = _summary

    fun updateSummary(
        teamName: String,
        runs: Int,
        wickets: Int,
        balls: Int,
        fours: Int,
        sixes: Int,
        extras: Int
    ) {
        val safeRuns = runs.coerceAtLeast(0)
        val safeWickets = wickets.coerceIn(0, 10)
        val safeBalls = balls.coerceAtLeast(0)
        val safeFours = fours.coerceAtLeast(0)
        val safeSixes = sixes.coerceAtLeast(0)
        val safeExtras = extras.coerceAtLeast(0)

        val runRate = if (safeBalls > 0) {
            "%.2f".format(
                safeRuns.toDouble() * 6 / safeBalls
            )
        } else {
            "0.00"
        }

        _summary.value = InningsSummary(
            teamName = teamName.trim(),
            runs = safeRuns,
            wickets = safeWickets,
            balls = safeBalls,
            overs = formatOvers(safeBalls),
            runRate = runRate,
            fours = safeFours,
            sixes = safeSixes,
            extras = safeExtras
        )
    }

    fun reset() {
        _summary.value = InningsSummary(
            teamName = "",
            runs = 0,
            wickets = 0,
            balls = 0,
            overs = "0.0",
            runRate = "0.00",
            fours = 0,
            sixes = 0,
            extras = 0
        )
    }

    private fun formatOvers(balls: Int): String {
        return "${balls / 6}.${balls % 6}"
    }
}
