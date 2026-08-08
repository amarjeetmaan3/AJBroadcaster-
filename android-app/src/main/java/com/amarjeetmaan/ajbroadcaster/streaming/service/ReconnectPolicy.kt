package com.amarjeetmaan.ajbroadcaster.streaming.service

data class ReconnectPolicy(
    val enabled: Boolean = true,
    val maxAttempts: Int = 5,
    val initialDelayMs: Long = 1_000L,
    val maxDelayMs: Long = 30_000L
) {

    init {
        require(maxAttempts >= 0) {
            "Maximum reconnect attempts cannot be negative."
        }

        require(initialDelayMs > 0) {
            "Initial reconnect delay must be positive."
        }

        require(maxDelayMs >= initialDelayMs) {
            "Maximum delay must be >= initial delay."
        }
    }

    fun delayForAttempt(
        attempt: Int
    ): Long {

        if (attempt <= 0) {
            return initialDelayMs
        }

        var delay =
            initialDelayMs

        repeat(
            minOf(
                attempt,
                30
            )
        ) {
            delay =
                (delay * 2)
                    .coerceAtMost(
                        maxDelayMs
                    )
        }

        return delay
    }

    fun canRetry(
        attempt: Int
    ): Boolean {

        return enabled &&
            attempt < maxAttempts
    }
}
