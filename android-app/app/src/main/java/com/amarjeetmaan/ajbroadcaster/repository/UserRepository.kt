package com.amarjeetmaan.ajbroadcaster.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Repository contract for user operations.
 *
 * Defines all data operations related to
 * authentication, user profiles, and sessions.
 */
interface UserRepository {

    /**
     * Signs in a user.
     */
    suspend fun signIn(
        email: String,
        password: String
    ): AppResult<User>

    /**
     * Registers a new user.
     */
    suspend fun signUp(
        user: User,
        password: String
    ): AppResult<User>

    /**
     * Signs out the current user.
     */
    suspend fun signOut(): AppResult<Unit>

    /**
     * Returns the currently signed-in user.
     */
    suspend fun getCurrentUser(): AppResult<User>

    /**
     * Observes the current user.
     */
    fun observeCurrentUser(): Flow<User>

    /**
     * Updates user profile.
     */
    suspend fun updateUser(
        user: User
    ): AppResult<Unit>

    /**
     * Deletes a user account.
     */
    suspend fun deleteUser(
        userId: String
    ): AppResult<Unit>

    /**
     * Sends a password reset email.
     */
    suspend fun resetPassword(
        email: String
    ): AppResult<Unit>

    /**
     * Updates user role.
     */
    suspend fun updateRole(
        userId: String,
        role: String
    ): AppResult<Unit>
}
