package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class ScoreControlState(
    val teamName: String = "CSK",
    val runs: Int = 0,
    val wickets: Int = 0,
    val balls: Int = 0,
    val overs: String = "0.0",
    val lastBall: String = "-"
)

@HiltViewModel
class ScoreControlViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(
        ScoreControlState()
    )

    val state: StateFlow<ScoreControlState>
        get() = _state

    fun addRuns(runs: Int) {
        if (runs !in listOf(1, 2, 3, 4, 5, 6)) {
            return
        }

        recordLegalDelivery(
            runs = runs,
            description = runs.toString()
        )
    }

    fun addDotBall() {
        recordLegalDelivery(
            runs = 0,
            description = "0"
        )
    }

    fun addWicket() {
        val current = _state.value

        recordLegalDelivery(
            runs = 0,
            description = "W"
        )

        _state.value = _state.value.copy(
            wickets = (current.wickets + 1).coerceAtMost(10)
        )
    }

    fun addExtra() {
        val current = _state.value

        _state.value = current.copy(
            runs = current.runs + 1,
            lastBall = "WD"
        )
    }

    private fun recordLegalDelivery(
        runs: Int,
        description: String
    ) {
        val current = _state.value
        val newBalls = current.balls + 1

        _state.value = current.copy(
            runs = current.runs + runs,
            balls = newBalls,
            overs = formatOvers(newBalls),
            lastBall = description
        )
    }

    private fun formatOvers(
        balls: Int
    ): String {
        return "${balls / 6}.${balls % 6}"
    }
}
