package com.amarjeetmaan.ajbroadcaster.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

/**
 * Global application CoroutineScope.
 *
 * Use ONLY for long-running operations that must survive
 * Activity or ViewModel recreation.
 *
 * Examples:
 * - Stream connection manager
 * - Background upload service
 * - Global logging
 *
 * Do NOT use this for screen-specific work.
 * ViewModels should continue using viewModelScope.
 */
object AppCoroutineScope {

    private val dispatcherProvider: DispatcherProvider =
        DefaultDispatcherProvider

    /**
     * Global application scope.
     */
    var scope: CoroutineScope =
        CoroutineScope(
            SupervisorJob() + dispatcherProvider.io
        )
        private set

    /**
     * Recreates the global scope after cancellation.
     */
    fun reset() {
        scope.cancel()

        scope = CoroutineScope(
            SupervisorJob() + dispatcherProvider.io
        )
    }
}
