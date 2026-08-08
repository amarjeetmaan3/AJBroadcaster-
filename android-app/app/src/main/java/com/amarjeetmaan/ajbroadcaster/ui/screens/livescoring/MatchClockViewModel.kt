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

data class MatchClockState(
    val elapsedSeconds: Long = 0L,
    val isRunning: Boolean = false,
    val displayTime: String = "00:00:00"
)

@HiltViewModel
class MatchClockViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(MatchClockState())

    val state: StateFlow<MatchClockState>
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

        _state.value = _state.value.copy(
            isRunning = true
        )

        timerJob?.cancel()

        timerJob = viewModelScope.launch {
            while (true) {
                delay(1000L)

                val nextSeconds =
                    _state.value.elapsedSeconds + 1

                _state.value = _state.value.copy(
                    elapsedSeconds = nextSeconds,
                    displayTime = formatTime(nextSeconds)
                )
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

        _state.value = MatchClockState()
    }

    private fun formatTime(
        totalSeconds: Long
    ): String {
        val hours = totalSeconds / 3600
        val minutes = (totalSeconds % 3600) / 60
        val seconds = totalSeconds % 60

        return "%02d:%02d:%02d".format(
            hours,
            minutes,
            seconds
        )
    }

    override fun onCleared() {
        timerJob?.cancel()
        super.onCleared()
    }
}
