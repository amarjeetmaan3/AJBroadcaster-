package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MatchTimerState(
    val remainingSeconds: Long = 20 * 60L,
    val isRunning: Boolean = false,
    val displayTime: String = "20:00"
)

@HiltViewModel
class MatchTimerViewModel @Inject constructor() : ViewModel() {

    private val initialSeconds = 20 * 60L

    private val _state = MutableStateFlow(
        MatchTimerState(
            remainingSeconds = initialSeconds,
            displayTime = formatTime(initialSeconds)
        )
    )

    val state: StateFlow<MatchTimerState>
        get() = _state

    private var timerJob: Job? = null

    fun toggle() {
        if (_state.value.isRunning) {
            pause()
        } else {
            start()
        }
    }

    fun start() {
        if (_state.value.isRunning) return
        if (_state.value.remainingSeconds <= 0L) return

        _state.value = _state.value.copy(
            isRunning = true
        )

        timerJob?.cancel()

        timerJob = viewModelScope.launch {
            while (_state.value.remainingSeconds > 0L) {
                delay(1000L)

                val nextSeconds =
                    (_state.value.remainingSeconds - 1L)
                        .coerceAtLeast(0L)

                _state.value = _state.value.copy(
                    remainingSeconds = nextSeconds,
                    displayTime = formatTime(nextSeconds),
                    isRunning = nextSeconds > 0L
                )

                if (nextSeconds == 0L) {
                    timerJob = null
                    break
                }
            }
        }
    }

    fun pause() {
        timerJob?.cancel()
        timerJob = null

        _state.value = _state.value.copy(
            isRunning = false
        )
    }

    fun reset() {
        timerJob?.cancel()
        timerJob = null

        _state.value = MatchTimerState(
            remainingSeconds = initialSeconds,
            displayTime = formatTime(initialSeconds),
            isRunning = false
        )
    }

    fun setDuration(
        minutes: Int,
        seconds: Int = 0
    ) {
        if (minutes < 0 || seconds !in 0..59) {
            return
        }

        timerJob?.cancel()
        timerJob = null

        val totalSeconds =
            minutes * 60L + seconds

        _state.value = MatchTimerState(
            remainingSeconds = totalSeconds,
            displayTime = formatTime(totalSeconds),
            isRunning = false
        )
    }

    private fun formatTime(
        totalSeconds: Long
    ): String {
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60

        return "%02d:%02d".format(
            minutes,
            seconds
        )
    }

    override fun onCleared() {
        timerJob?.cancel()
        super.onCleared()
    }
}
