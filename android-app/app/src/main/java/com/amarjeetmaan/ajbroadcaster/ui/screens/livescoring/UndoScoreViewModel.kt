package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class ScoreSnapshot(
    val runs: Int,
    val wickets: Int,
    val balls: Int,
    val lastEvent: String
)

data class UndoScoreState(
    val runs: Int = 0,
    val wickets: Int = 0,
    val balls: Int = 0,
    val overs: String = "0.0",
    val lastEvent: String = "-",
    val canUndo: Boolean = false,
    val historySize: Int = 0
)

@HiltViewModel
class UndoScoreViewModel @Inject constructor() : ViewModel() {

    private val history = mutableListOf<ScoreSnapshot>()

    private val _state = MutableStateFlow(
        UndoScoreState()
    )

    val state: StateFlow<UndoScoreState>
        get() = _state

    fun recordEvent(
        runs: Int,
        wicket: Boolean,
        description: String,
        legalDelivery: Boolean = true
    ) {
        val current = _state.value

        history.add(
            ScoreSnapshot(
                runs = current.runs,
                wickets = current.wickets,
                balls = current.balls,
                lastEvent = current.lastEvent
            )
        )

        val newBalls =
            if (legalDelivery) {
                current.balls + 1
            } else {
                current.balls
            }

        val newWickets =
            if (wicket) {
                (current.wickets + 1).coerceAtMost(10)
            } else {
                current.wickets
            }

        _state.value = current.copy(
            runs = current.runs + runs.coerceAtLeast(0),
            wickets = newWickets,
            balls = newBalls,
            overs = formatOvers(newBalls),
            lastEvent = description,
            canUndo = true,
            historySize = history.size
        )
    }

    fun undoLastEvent() {
        if (history.isEmpty()) {
            return
        }

        val previous = history.removeAt(history.lastIndex)

        _state.value = UndoScoreState(
            runs = previous.runs,
            wickets = previous.wickets,
            balls = previous.balls,
            overs = formatOvers(previous.balls),
            lastEvent = previous.lastEvent,
            canUndo = history.isNotEmpty(),
            historySize = history.size
        )
    }

    fun clearHistory() {
        history.clear()

        _state.value = _state.value.copy(
            canUndo = false,
            historySize = 0
        )
    }

    private fun formatOvers(
        balls: Int
    ): String {
        return "${balls / 6}.${balls % 6}"
    }
}
