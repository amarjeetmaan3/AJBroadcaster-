package com.amarjeetmaan.ajbroadcaster.ui.screens.scorer

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * ViewModel for ScorerScreen.
 *
 * Will communicate with ScoreManager
 * to update every ball of the match.
 */
@HiltViewModel
class ScorerViewModel @Inject constructor() : ViewModel() {

    private val _ballNumber =
        MutableStateFlow(0)

    val ballNumber: StateFlow<Int>
        get() = _ballNumber

    /**
     * Moves to the next ball.
     */
    fun nextBall() {
        _ballNumber.value++
    }

    /**
     * Resets the innings.
     */
    fun resetInnings() {
        _ballNumber.value = 0
    }
}
