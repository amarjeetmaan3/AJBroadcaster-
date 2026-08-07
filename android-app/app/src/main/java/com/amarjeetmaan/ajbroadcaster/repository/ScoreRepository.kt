package com.amarjeetmaan.ajbroadcaster.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.Ball
import com.amarjeetmaan.ajbroadcaster.data.model.Innings
import com.amarjeetmaan.ajbroadcaster.data.model.Over
import com.amarjeetmaan.ajbroadcaster.data.model.Score
import kotlinx.coroutines.flow.Flow

/**
 * Repository contract for live scoring operations.
 *
 * Handles score updates, innings, overs,
 * deliveries and scoreboard synchronization.
 */
interface ScoreRepository {

    /**
     * Returns live score.
     */
    fun observeScore(
        matchId: String
    ): Flow<Score>

    /**
     * Returns current innings.
     */
    fun observeInnings(
        inningsId: String
    ): Flow<Innings>

    /**
     * Returns all overs.
     */
    fun observeOvers(
        inningsId: String
    ): Flow<List<Over>>

    /**
     * Returns all balls for an over.
     */
    fun observeBalls(
        overId: String
    ): Flow<List<Ball>>

    /**
     * Records a delivery.
     */
    suspend fun addBall(
        ball: Ball
    ): AppResult<Unit>

    /**
     * Updates live score.
     */
    suspend fun updateScore(
        score: Score
    ): AppResult<Unit>

    /**
     * Starts an innings.
     */
    suspend fun startInnings(
        innings: Innings
    ): AppResult<Unit>

    /**
     * Ends the current innings.
     */
    suspend fun endInnings(
        inningsId: String
    ): AppResult<Unit>

    /**
     * Undo the last recorded delivery.
     */
    suspend fun undoLastBall(
        matchId: String
    ): AppResult<Unit>
}
