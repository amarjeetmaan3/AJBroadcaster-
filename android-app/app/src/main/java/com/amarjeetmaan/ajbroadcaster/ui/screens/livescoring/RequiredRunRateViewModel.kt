package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class RequiredRunRateState(
    val target: Int = 126,
    val currentRuns: Int = 80,
    val runsRequired: Int = 46,
    val ballsRemaining: Int = 27,
    val requiredRunRate: String = "10.22"
)

@HiltViewModel
class RequiredRunRateViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(
        RequiredRunRateState()
    )

    val state: StateFlow<RequiredRunRateState>
        get() = _state

    fun calculate(
        target: Int,
        currentRuns: Int,
        ballsRemaining: Int
    ) {
        val safeTarget = target.coerceAtLeast(0)
        val safeRuns = currentRuns.coerceAtLeast(0)
        val safeBalls = ballsRemaining.coerceAtLeast(0)

        val runsRequired =
            (safeTarget - safeRuns).coerceAtLeast(0)

        val rate =
            if (safeBalls > 0) {
                "%.2f".format(
                    runsRequired.toDouble() * 6 / safeBalls
                )
            } else {
                "0.00"
            }

        _state.value = RequiredRunRateState(
            target = safeTarget,
            currentRuns = safeRuns,
            runsRequired = runsRequired,
            ballsRemaining = safeBalls,
            requiredRunRate = rate
        )
    }

    fun reset() {
        _state.value = RequiredRunRateState()
    }
}
