package com.amarjeetmaan.ajbroadcaster.data.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.Ball
import com.amarjeetmaan.ajbroadcaster.data.model.Innings
import com.amarjeetmaan.ajbroadcaster.data.model.Over
import com.amarjeetmaan.ajbroadcaster.data.model.Score
import com.amarjeetmaan.ajbroadcaster.repository.ScoreRepository
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Firebase implementation of ScoreRepository.
 *
 * NOTE:
 * This is the initial implementation.
 * Complete Firebase synchronization will
 * be added in future phases.
 */
class FirebaseScoreRepository(
    private val database: FirebaseDatabase
) : ScoreRepository {

    private val scoresRef =
        database.getReference("scores")

    private val inningsRef =
        database.getReference("innings")

    private val oversRef =
        database.getReference("overs")

    private val ballsRef =
        database.getReference("balls")

    override fun observeScore(
        matchId: String
    ): Flow<Score> = flow {
        // Firebase listener will be added later.
    }

    override fun observeInnings(
        inningsId: String
    ): Flow<Innings> = flow {
        // Firebase listener will be added later.
    }

    override fun observeOvers(
        inningsId: String
    ): Flow<List<Over>> = flow {
        // Firebase listener will be added later.
    }

    override fun observeBalls(
        overId: String
    ): Flow<List<Ball>> = flow {
        // Firebase listener will be added later.
    }

    override suspend fun addBall(
        ball: Ball
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun updateScore(
        score: Score
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun startInnings(
        innings: Innings
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun endInnings(
        inningsId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun undoLastBall(
        matchId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }
}
