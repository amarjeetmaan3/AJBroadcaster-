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

data class OverTimerState(
    val overNumber: Int = 1,
    val remainingSeconds: Long = 90L,
    val isRunning: Boolean = false,
    val displayTime: String = "01:30"
)

@HiltViewModel
class OverTimerViewModel @Inject constructor() : ViewModel() {

    private val defaultSeconds = 90L

    private val _state = MutableStateFlow(
        OverTimerState()
    )

    val state: StateFlow<OverTimerState>
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

                val remaining =
                    (_state.value.remainingSeconds - 1L)
                        .coerceAtLeast(0L)

                _state.value = _state.value.copy(
                    remainingSeconds = remaining,
                    displayTime = formatTime(remaining),
                    isRunning = remaining > 0L
                )

                if (remaining == 0L) {
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

        _state.value = _state.value.copy(
            remainingSeconds = defaultSeconds,
            displayTime = formatTime(defaultSeconds),
            isRunning = false
        )
    }

    fun setOverNumber(
        overNumber: Int
    ) {
        if (overNumber < 1) return

        _state.value = _state.value.copy(
            overNumber = overNumber
        )
    }

    fun setDuration(
        seconds: Long
    ) {
        if (seconds < 0L) return

        timerJob?.cancel()
        timerJob = null

        _state.value = _state.value.copy(
            remainingSeconds = seconds,
            displayTime = formatTime(seconds),
            isRunning = false
        )
    }

    private fun formatTime(
        seconds: Long
    ): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60

        return "%02d:%02d".format(
            minutes,
            remainingSeconds
        )
    }

    override fun onCleared() {
        timerJob?.cancel()
        super.onCleared()
    }
}
