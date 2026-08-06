package com.amarjeetmaan.ajbroadcaster.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.core.ErrorHandler
import com.amarjeetmaan.ajbroadcaster.core.Logger

/**
 * Base class for all repositories.
 *
 * Every repository should inherit from this class
 * to ensure consistent exception handling and logging.
 *
 * Example:
 * - AuthRepository
 * - TournamentRepository
 * - MatchRepository
 * - PlayerRepository
 * - StreamingRepository
 */
abstract class BaseRepository {

    /**
     * Executes repository operations safely.
     *
     * All exceptions are caught, logged,
     * and converted into AppResult.Failure.
     */
    protected suspend fun <T> executeSafely(
        actionName: String,
        block: suspend () -> T
    ): AppResult<T> {

        return try {

            val result = block()

            Logger.d(
                message = "$actionName completed successfully."
            )

            AppResult.Success(result)

        } catch (exception: Exception) {

            Logger.e(
                message = "$actionName failed.",
                throwable = exception
            )

            AppResult.Failure(
                exception = exception,
                message = ErrorHandler.getErrorMessage(exception)
            )
        }
    }
}
