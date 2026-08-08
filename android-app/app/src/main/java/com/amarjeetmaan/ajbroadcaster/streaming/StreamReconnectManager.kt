package com.amarjeetmaan.ajbroadcaster.streaming

import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Controls automatic stream reconnection attempts.
 */
@Singleton
class StreamReconnectManager @Inject constructor() {

    companion object {
        const val DEFAULT_MAX_ATTEMPTS = 5

        private const val INITIAL_DELAY_MS = 1_000L
        private const val MAX_DELAY_MS = 15_000L
    }

    private var attempts: Int = 0

    /**
     * Performs reconnect attempts using exponential backoff.
     *
     * The actual reconnect operation is supplied by the caller.
     */
    suspend fun reconnect(
        maxAttempts: Int = DEFAULT_MAX_ATTEMPTS,
        reconnectAction: suspend () -> Boolean
    ): Boolean {

        require(
            maxAttempts > 0
        ) {
            "Maximum attempts must be greater than zero."
        }

        attempts = 0

        while (attempts < maxAttempts) {

            attempts++

            val success =
                runCatching {
                    reconnectAction()
                }.getOrDefault(false)

            if (success) {
                attempts = 0
                return true
            }

            if (attempts < maxAttempts) {

                val delayMs =
                    (
                        INITIAL_DELAY_MS *
                            (1L shl
                                (attempts - 1)
                        )
                    ).coerceAtMost(
                        MAX_DELAY_MS
                    )

                delay(delayMs)
            }
        }

        return false
    }

    /**
     * Returns current reconnect attempt.
     */
    fun getAttemptCount(): Int {
        return attempts
    }

    /**
     * Cancels/reset reconnect state.
     */
    fun reset() {
        attempts = 0
    }
}
