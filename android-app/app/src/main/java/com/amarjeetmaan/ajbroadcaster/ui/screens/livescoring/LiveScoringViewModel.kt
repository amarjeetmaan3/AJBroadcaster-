package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * ViewModel for LiveScoringScreen.
 *
 * Will coordinate the UI with
 * ScoreManager during live matches.
 */
@HiltViewModel
class LiveScoringViewModel @Inject constructor() : ViewModel() {

    private val _inningsStarted =
        MutableStateFlow(false)

    val inningsStarted: StateFlow<Boolean>
        get() = _inningsStarted

    /**
     * Starts the innings.
     *
     * ScoreManager integration
     * will be added later.
     */
    fun startInnings() {
        _inningsStarted.value = true
    }
}
