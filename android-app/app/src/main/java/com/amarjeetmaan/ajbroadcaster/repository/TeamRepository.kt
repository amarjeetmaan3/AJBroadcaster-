package com.amarjeetmaan.ajbroadcaster.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.Team
import kotlinx.coroutines.flow.Flow

/**
 * Repository contract for Team operations.
 *
 * Defines all data operations related to cricket teams.
 * Implementations belong in the data layer.
 */
interface TeamRepository {

    /**
     * Creates a new team.
     */
    suspend fun createTeam(team: Team): AppResult<Unit>

    /**
     * Updates an existing team.
     */
    suspend fun updateTeam(team: Team): AppResult<Unit>

    /**
     * Deletes a team.
     */
    suspend fun deleteTeam(teamId: String): AppResult<Unit>

    /**
     * Returns a team by its ID.
     */
    suspend fun getTeam(teamId: String): AppResult<Team>

    /**
     * Observes a team for live updates.
     */
    fun observeTeam(teamId: String): Flow<Team>

    /**
     * Returns all teams in a tournament.
     */
    suspend fun getTournamentTeams(
        tournamentId: String
    ): AppResult<List<Team>>

    /**
     * Observes all teams in a tournament.
     */
    fun observeTournamentTeams(
        tournamentId: String
    ): Flow<List<Team>>

    /**
     * Adds a player to a team.
     */
    suspend fun addPlayer(
        teamId: String,
        playerId: String
    ): AppResult<Unit>

    /**
     * Removes a player from a team.
     */
    suspend fun removePlayer(
        teamId: String,
        playerId: String
    ): AppResult<Unit>
}
