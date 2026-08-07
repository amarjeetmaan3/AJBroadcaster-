package com.amarjeetmaan.ajbroadcaster.manager

import com.amarjeetmaan.ajbroadcaster.data.model.Ball
import com.amarjeetmaan.ajbroadcaster.data.model.Innings
import com.amarjeetmaan.ajbroadcaster.data.model.Match
import com.amarjeetmaan.ajbroadcaster.data.model.Over
import com.amarjeetmaan.ajbroadcaster.data.model.Score
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Core cricket scoring manager.
 *
 * Responsible for ball-by-ball scoring,
 * innings management, strike rotation,
 * wickets, extras, partnerships,
 * undo/redo, and scoreboard updates.
 *
 * Complete scoring engine will
 * be implemented in future phases.
 */
@Singleton
class ScoreManager @Inject constructor(
    private val graphicsManager: GraphicsManager
) {

    private val _score =
        MutableStateFlow<Score?>(null)

    private val _currentMatch =
        MutableStateFlow<Match?>(null)

    private val _currentInnings =
        MutableStateFlow<Innings?>(null)

    private val _currentOver =
        MutableStateFlow<Over?>(null)

    /**
     * Emits current score.
     */
    val score: StateFlow<Score?>
        get() = _score

    /**
     * Emits current match.
     */
    val currentMatch: StateFlow<Match?>
        get() = _currentMatch

    /**
     * Starts scoring a match.
     */
    fun startMatch(
        match: Match
    ) {
        _currentMatch.value = match
    }

    /**
     * Starts an innings.
     */
    fun startInnings(
        innings: Innings
    ) {
        _currentInnings.value = innings
    }

    /**
     * Starts an over.
     */
    fun startOver(
        over: Over
    ) {
        _currentOver.value = over
    }

    /**
     * Records a delivery.
     *
     * Full cricket rules will
     * be implemented later.
     */
    fun recordBall(
        ball: Ball
    ) {
        // Reserved.
    }

    /**
     * Updates score.
     */
    fun updateScore(
        score: Score
    ) {
        _score.value = score
    }

    /**
     * Undoes the previous delivery.
     */
    fun undoLastBall() {
        // Reserved.
    }

    /**
     * Redoes the last undone delivery.
     */
    fun redoLastBall() {
        // Reserved.
    }

    /**
     * Ends the current innings.
     */
    fun endInnings() {
        _currentInnings.value = null
    }

    /**
     * Ends the current match.
     */
    fun endMatch() {
        _currentMatch.value = null
        _currentInnings.value = null
        _currentOver.value = null
        _score.value = null
        graphicsManager.clearGraphics()
    }
}
