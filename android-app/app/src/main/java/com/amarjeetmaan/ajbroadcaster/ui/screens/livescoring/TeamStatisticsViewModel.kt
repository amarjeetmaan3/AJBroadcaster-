package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class TeamStatistics(
    val teamName: String = "CSK",
    val matches: Int = 1,
    val wins: Int = 1,
    val losses: Int = 0,
    val ties: Int = 0,
    val totalRuns: Int = 125,
    val totalWickets: Int = 4
) {
    val winPercentage: String
        get() {
            if (matches <= 0) return "0.00"

            return "%.2f".format(
                wins.toDouble() * 100 / matches
            )
        }
}

@HiltViewModel
class TeamStatisticsViewModel @Inject constructor() : ViewModel() {

    private val _statistics = MutableStateFlow(
        TeamStatistics()
    )

    val statistics: StateFlow<TeamStatistics>
        get() = _statistics

    fun updateStatistics(
        teamName: String,
        matches: Int,
        wins: Int,
        losses: Int,
        ties: Int,
        totalRuns: Int,
        totalWickets: Int
    ) {
        val safeMatches = matches.coerceAtLeast(0)
        val safeWins = wins.coerceAtLeast(0)
        val safeLosses = losses.coerceAtLeast(0)
        val safeTies = ties.coerceAtLeast(0)

        _statistics.value = TeamStatistics(
            teamName = teamName.trim(),
            matches = safeMatches,
            wins = safeWins,
            losses = safeLosses,
            ties = safeTies,
            totalRuns = totalRuns.coerceAtLeast(0),
            totalWickets = totalWickets.coerceAtLeast(0)
        )
    }

    fun reset() {
        _statistics.value = TeamStatistics(
            teamName = "",
            matches = 0,
            wins = 0,
            losses = 0,
            ties = 0,
            totalRuns = 0,
            totalWickets = 0
        )
    }
}
