package com.amarjeetmaan.ajbroadcaster.ui.screens.scoreboard

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * ViewModel for ScoreboardScreen.
 */
@HiltViewModel
class ScoreboardViewModel @Inject constructor() : ViewModel() {

    private val _score =
        MutableStateFlow("125/4")

    val score: StateFlow<String>
        get() = _score

    /**
     * Updates the scoreboard.
     *
     * ScoreManager integration
     * will be added later.
     */
    fun updateScore(
        newScore: String
    ) {
        _score.value = newScore
    }
}
