package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class MatchStatistics(
    val totalRuns: Int = 125,
    val totalWickets: Int = 4,
    val totalFours: Int = 11,
    val totalSixes: Int = 5,
    val totalExtras: Int = 9,
    val runRate: String = "8.06",
    val highestPartnership: Int = 48
)

@HiltViewModel
class MatchStatisticsViewModel @Inject constructor() : ViewModel() {

    private val _statistics = MutableStateFlow(
        MatchStatistics()
    )

    val statistics: StateFlow<MatchStatistics>
        get() = _statistics

    fun updateStatistics(
        totalRuns: Int,
        totalWickets: Int,
        totalFours: Int,
        totalSixes: Int,
        totalExtras: Int,
        balls: Int,
        highestPartnership: Int
    ) {
        val safeRuns = totalRuns.coerceAtLeast(0)
        val safeWickets = totalWickets.coerceIn(0, 10)
        val safeFours = totalFours.coerceAtLeast(0)
        val safeSixes = totalSixes.coerceAtLeast(0)
        val safeExtras = totalExtras.coerceAtLeast(0)
        val safeBalls = balls.coerceAtLeast(0)
        val safePartnership = highestPartnership.coerceAtLeast(0)

        val runRate = if (safeBalls > 0) {
            "%.2f".format(
                safeRuns.toDouble() * 6 / safeBalls
            )
        } else {
            "0.00"
        }

        _statistics.value = MatchStatistics(
            totalRuns = safeRuns,
            totalWickets = safeWickets,
            totalFours = safeFours,
            totalSixes = safeSixes,
            totalExtras = safeExtras,
            runRate = runRate,
            highestPartnership = safePartnership
        )
    }

    fun reset() {
        _statistics.value = MatchStatistics(
            totalRuns = 0,
            totalWickets = 0,
            totalFours = 0,
            totalSixes = 0,
            totalExtras = 0,
            runRate = "0.00",
            highestPartnership = 0
        )
    }
}
