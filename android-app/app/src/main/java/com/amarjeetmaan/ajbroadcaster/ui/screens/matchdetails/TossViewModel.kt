package com.amarjeetmaan.ajbroadcaster.ui.screens.matchdetails

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * ViewModel for TossScreen.
 *
 * Stores the toss winner and the
 * decision selected by the captain.
 */
@HiltViewModel
class TossViewModel @Inject constructor() : ViewModel() {

    private val _tossWinner =
        MutableStateFlow<String?>(null)

    val tossWinner: StateFlow<String?>
        get() = _tossWinner

    private val _decision =
        MutableStateFlow<String?>(null)

    val decision: StateFlow<String?>
        get() = _decision

    fun setTossWinner(teamName: String) {
        _tossWinner.value = teamName
    }

    fun setDecision(value: String) {
        _decision.value = value
    }

    fun resetToss() {
        _tossWinner.value = null
        _decision.value = null
    }
}
