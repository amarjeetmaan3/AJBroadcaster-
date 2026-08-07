package com.amarjeetmaan.ajbroadcaster.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.Sponsor
import kotlinx.coroutines.flow.Flow

/**
 * Repository contract for Sponsor operations.
 *
 * Defines all data operations related to
 * sponsors and advertisements.
 */
interface SponsorRepository {

    /**
     * Creates a sponsor.
     */
    suspend fun createSponsor(
        sponsor: Sponsor
    ): AppResult<Unit>

    /**
     * Updates sponsor information.
     */
    suspend fun updateSponsor(
        sponsor: Sponsor
    ): AppResult<Unit>

    /**
     * Deletes a sponsor.
     */
    suspend fun deleteSponsor(
        sponsorId: String
    ): AppResult<Unit>

    /**
     * Returns sponsor details.
     */
    suspend fun getSponsor(
        sponsorId: String
    ): AppResult<Sponsor>

    /**
     * Observes sponsor updates.
     */
    fun observeSponsor(
        sponsorId: String
    ): Flow<Sponsor>

    /**
     * Returns all sponsors for a tournament.
     */
    suspend fun getTournamentSponsors(
        tournamentId: String
    ): AppResult<List<Sponsor>>

    /**
     * Observes tournament sponsors.
     */
    fun observeTournamentSponsors(
        tournamentId: String
    ): Flow<List<Sponsor>>

    /**
     * Activates a sponsor.
     */
    suspend fun activateSponsor(
        sponsorId: String
    ): AppResult<Unit>

    /**
     * Deactivates a sponsor.
     */
    suspend fun deactivateSponsor(
        sponsorId: String
    ): AppResult<Unit>
}
