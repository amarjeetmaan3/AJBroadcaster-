package com.amarjeetmaan.ajbroadcaster.data.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.Tournament
import com.amarjeetmaan.ajbroadcaster.repository.TournamentRepository
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Firebase implementation of TournamentRepository.
 *
 * NOTE:
 * This is the initial implementation.
 * Firebase logic will be added in future phases.
 */
class FirebaseTournamentRepository(
    private val database: FirebaseDatabase
) : TournamentRepository {

    private val tournamentsRef =
        database.getReference("tournaments")

    override suspend fun createTournament(
        tournament: Tournament
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun updateTournament(
        tournament: Tournament
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun deleteTournament(
        tournamentId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun getTournament(
        tournamentId: String
    ): AppResult<Tournament> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override fun observeTournament(
        tournamentId: String
    ): Flow<Tournament> = flow {
        // Firebase listener will be added later.
    }

    override suspend fun getAllTournaments(): AppResult<List<Tournament>> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override fun observeAllTournaments(): Flow<List<Tournament>> = flow {
        // Firebase listener will be added later.
    }

    override suspend fun openRegistration(
        tournamentId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun closeRegistration(
        tournamentId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }
}
