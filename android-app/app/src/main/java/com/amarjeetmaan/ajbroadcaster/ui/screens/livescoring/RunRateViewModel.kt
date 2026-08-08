package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class RunRateState(
    val runs: Int = 80,
    val balls: Int = 63,
    val overs: String = "10.3",
    val runRate: String = "7.62"
)

@HiltViewModel
class RunRateViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(
        RunRateState()
    )

    val state: StateFlow<RunRateState>
        get() = _state

    fun calculate(
        runs: Int,
        balls: Int
    ) {
        val safeRuns = runs.coerceAtLeast(0)
        val safeBalls = balls.coerceAtLeast(0)

        val runRate =
            if (safeBalls > 0) {
                "%.2f".format(
                    safeRuns.toDouble() * 6 / safeBalls
                )
            } else {
                "0.00"
            }

        _state.value = RunRateState(
            runs = safeRuns,
            balls = safeBalls,
            overs = formatOvers(safeBalls),
            runRate = runRate
        )
    }

    fun reset() {
        _state.value = RunRateState(
            runs = 0,
            balls = 0,
            overs = "0.0",
            runRate = "0.00"
        )
    }

    private fun formatOvers(
        balls: Int
    ): String {
        return "${balls / 6}.${balls % 6}"
    }
}
