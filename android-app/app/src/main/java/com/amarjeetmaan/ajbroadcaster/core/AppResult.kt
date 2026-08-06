package com.amarjeetmaan.ajbroadcaster.core

/**
 * Repository/Domain layer result wrapper.
 *
 * Use this for:
 * - Repository return values
 * - UseCase results
 * - Domain operations
 *
 * Do NOT expose AppResult directly to the UI.
 * ViewModels should convert AppResult into Resource before sending data to Compose.
 */
sealed class AppResult<out T> {

    /**
     * Operation completed successfully.
     */
    data class Success<T>(
        val data: T
    ) : AppResult<T>()

    /**
     * Operation failed.
     */
    data class Failure(
        val exception: Throwable,
        val message: String = exception.message ?: "Unknown error"
    ) : AppResult<Nothing>()
}
