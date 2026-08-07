package com.amarjeetmaan.ajbroadcaster.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.Match
import kotlinx.coroutines.flow.Flow

/**
 * Repository contract for Match operations.
 *
 * Defines all data operations related to cricket matches.
 * Implementations belong in the data layer.
 */
interface MatchRepository {

    /**
     * Creates a new match.
     */
    suspend fun createMatch(match: Match): AppResult<Unit>

    /**
     * Updates an existing match.
     */
    suspend fun updateMatch(match: Match): AppResult<Unit>

    /**
     * Deletes a match.
     */
    suspend fun deleteMatch(matchId: String): AppResult<Unit>

    /**
     * Returns a match by its ID.
     */
    suspend fun getMatch(matchId: String): AppResult<Match>

    /**
     * Observes a match for live updates.
     */
    fun observeMatch(matchId: String): Flow<Match>

    /**
     * Returns all matches for a tournament.
     */
    suspend fun getTournamentMatches(
        tournamentId: String
    ): AppResult<List<Match>>

    /**
     * Observes all matches for a tournament.
     */
    fun observeTournamentMatches(
        tournamentId: String
    ): Flow<List<Match>>

    /**
     * Starts a match.
     */
    suspend fun startMatch(matchId: String): AppResult<Unit>

    /**
     * Ends a match.
     */
    suspend fun endMatch(matchId: String): AppResult<Unit>
}
