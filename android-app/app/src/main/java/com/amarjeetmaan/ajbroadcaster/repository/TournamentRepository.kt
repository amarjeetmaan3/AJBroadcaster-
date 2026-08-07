package com.amarjeetmaan.ajbroadcaster.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.Tournament
import kotlinx.coroutines.flow.Flow

/**
 * Repository contract for Tournament operations.
 *
 * Defines all data operations related to tournaments.
 * Implementations belong in the data layer.
 */
interface TournamentRepository {

    /**
     * Creates a new tournament.
     */
    suspend fun createTournament(
        tournament: Tournament
    ): AppResult<Unit>

    /**
     * Updates an existing tournament.
     */
    suspend fun updateTournament(
        tournament: Tournament
    ): AppResult<Unit>

    /**
     * Deletes a tournament.
     */
    suspend fun deleteTournament(
        tournamentId: String
    ): AppResult<Unit>

    /**
     * Returns a tournament by its ID.
     */
    suspend fun getTournament(
        tournamentId: String
    ): AppResult<Tournament>

    /**
     * Observes a tournament for live updates.
     */
    fun observeTournament(
        tournamentId: String
    ): Flow<Tournament>

    /**
     * Returns all tournaments.
     */
    suspend fun getAllTournaments(): AppResult<List<Tournament>>

    /**
     * Observes all tournaments.
     */
    fun observeAllTournaments(): Flow<List<Tournament>>

    /**
     * Opens tournament registration.
     */
    suspend fun openRegistration(
        tournamentId: String
    ): AppResult<Unit>

    /**
     * Closes tournament registration.
     */
    suspend fun closeRegistration(
        tournamentId: String
    ): AppResult<Unit>
}
