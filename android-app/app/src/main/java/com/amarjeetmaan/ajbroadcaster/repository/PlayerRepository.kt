package com.amarjeetmaan.ajbroadcaster.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.Player
import kotlinx.coroutines.flow.Flow

/**
 * Repository contract for Player operations.
 *
 * Defines all data operations related to players.
 * Implementations belong in the data layer.
 */
interface PlayerRepository {

    /**
     * Creates a new player.
     */
    suspend fun createPlayer(player: Player): AppResult<Unit>

    /**
     * Updates an existing player.
     */
    suspend fun updatePlayer(player: Player): AppResult<Unit>

    /**
     * Deletes a player.
     */
    suspend fun deletePlayer(playerId: String): AppResult<Unit>

    /**
     * Returns a player by ID.
     */
    suspend fun getPlayer(playerId: String): AppResult<Player>

    /**
     * Observes a player for live updates.
     */
    fun observePlayer(playerId: String): Flow<Player>

    /**
     * Returns all players of a team.
     */
    suspend fun getTeamPlayers(
        teamId: String
    ): AppResult<List<Player>>

    /**
     * Observes all players of a team.
     */
    fun observeTeamPlayers(
        teamId: String
    ): Flow<List<Player>>

    /**
     * Transfers a player to another team.
     */
    suspend fun transferPlayer(
        playerId: String,
        newTeamId: String
    ): AppResult<Unit>

    /**
     * Searches players by name.
     */
    suspend fun searchPlayers(
        query: String
    ): AppResult<List<Player>>
}
