package com.amarjeetmaan.ajbroadcaster.data.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.Match
import com.amarjeetmaan.ajbroadcaster.repository.MatchRepository
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Firebase implementation of MatchRepository.
 *
 * NOTE:
 * This is the initial implementation.
 * Firebase logic will be added in future phases.
 */
class FirebaseMatchRepository(
    private val database: FirebaseDatabase
) : MatchRepository {

    private val matchesRef =
        database.getReference("matches")

    override suspend fun createMatch(
        match: Match
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun updateMatch(
        match: Match
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun deleteMatch(
        matchId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun getMatch(
        matchId: String
    ): AppResult<Match> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override fun observeMatch(
        matchId: String
    ): Flow<Match> = flow {
        // Firebase listener will be added later.
    }

    override suspend fun getTournamentMatches(
        tournamentId: String
    ): AppResult<List<Match>> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override fun observeTournamentMatches(
        tournamentId: String
    ): Flow<List<Match>> = flow {
        // Firebase listener will be added later.
    }

    override suspend fun startMatch(
        matchId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun endMatch(
        matchId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }
}
