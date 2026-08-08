package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class ScoreHistoryEvent(
    val ball: String,
    val description: String,
    val runs: Int,
    val scoreAfter: String
)

@HiltViewModel
class ScoreHistoryViewModel @Inject constructor() : ViewModel() {

    private val _events = MutableStateFlow(
        listOf(
            ScoreHistoryEvent(
                ball = "1.1",
                description = "Dot ball",
                runs = 0,
                scoreAfter = "0/0"
            ),
            ScoreHistoryEvent(
                ball = "1.2",
                description = "FOUR",
                runs = 4,
                scoreAfter = "4/0"
            ),
            ScoreHistoryEvent(
                ball = "1.3",
                description = "Single",
                runs = 1,
                scoreAfter = "5/0"
            )
        )
    )

    val events: StateFlow<List<ScoreHistoryEvent>>
        get() = _events

    fun addEvent(
        ball: String,
        description: String,
        runs: Int,
        scoreAfter: String
    ) {
        _events.value = _events.value + ScoreHistoryEvent(
            ball = ball,
            description = description,
            runs = runs,
            scoreAfter = scoreAfter
        )
    }

    fun removeLastEvent() {
        if (_events.value.isNotEmpty()) {
            _events.value = _events.value.dropLast(1)
        }
    }

    fun clearHistory() {
        _events.value = emptyList()
    }
}
