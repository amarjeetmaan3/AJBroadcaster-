package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class BallEntry(
    val ballNumber: String,
    val runs: Int,
    val extras: Int,
    val result: String
)

@HiltViewModel
class BallEntryViewModel @Inject constructor() : ViewModel() {

    private val _balls = MutableStateFlow(
        listOf(
            BallEntry(
                ballNumber = "1.1",
                runs = 0,
                extras = 0,
                result = "Dot ball"
            ),
            BallEntry(
                ballNumber = "1.2",
                runs = 4,
                extras = 0,
                result = "FOUR"
            )
        )
    )

    val balls: StateFlow<List<BallEntry>>
        get() = _balls

    fun addBall(
        ballNumber: String,
        runs: Int,
        extras: Int,
        result: String
    ) {
        _balls.value = _balls.value + BallEntry(
            ballNumber = ballNumber,
            runs = runs.coerceAtLeast(0),
            extras = extras.coerceAtLeast(0),
            result = result
        )
    }

    fun removeLastBall() {
        if (_balls.value.isNotEmpty()) {
            _balls.value = _balls.value.dropLast(1)
        }
    }

    fun clearBalls() {
        _balls.value = emptyList()
    }
}
