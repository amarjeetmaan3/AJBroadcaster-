package com.amarjeetmaan.ajbroadcaster.core

/**
 * Represents UI state exposed by ViewModels.
 *
 * Use this class only for UI state.
 * Repository and domain layers should use AppResult instead.
 */
sealed class Resource<out T> {

    /**
     * Operation completed successfully.
     */
    data class Success<T>(
        val data: T
    ) : Resource<T>()

    /**
     * Operation failed.
     */
    data class Error(
        val message: String,
        val throwable: Throwable? = null
    ) : Resource<Nothing>()

    /**
     * Operation is currently running.
     */
    object Loading : Resource<Nothing>()
}
