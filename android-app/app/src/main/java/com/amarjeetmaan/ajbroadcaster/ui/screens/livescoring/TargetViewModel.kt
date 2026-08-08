package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class TargetInfo(
    val target: Int,
    val currentScore: String,
    val runsRequired: Int,
    val ballsRemaining: Int,
    val requiredRunRate: String
)

@HiltViewModel
class TargetViewModel @Inject constructor() : ViewModel() {

    private val _target = MutableStateFlow(
        TargetInfo(
            target = 126,
            currentScore = "80/3",
            runsRequired = 46,
            ballsRemaining = 27,
            requiredRunRate = "10.22"
        )
    )

    val target: StateFlow<TargetInfo>
        get() = _target

    fun updateTarget(
        target: Int,
        currentRuns: Int,
        wickets: Int,
        ballsRemaining: Int
    ) {
        val required =
            (target - currentRuns).coerceAtLeast(0)

        val requiredRate =
            if (ballsRemaining > 0) {
                "%.2f".format(
                    required.toDouble() * 6 / ballsRemaining
                )
            } else {
                "0.00"
            }

        _target.value = TargetInfo(
            target = target,
            currentScore = "$currentRuns/$wickets",
            runsRequired = required,
            ballsRemaining = ballsRemaining.coerceAtLeast(0),
            requiredRunRate = requiredRate
        )
    }

    fun reset() {
        _target.value = TargetInfo(
            target = 0,
            currentScore = "0/0",
            runsRequired = 0,
            ballsRemaining = 0,
            requiredRunRate = "0.00"
        )
    }
}
