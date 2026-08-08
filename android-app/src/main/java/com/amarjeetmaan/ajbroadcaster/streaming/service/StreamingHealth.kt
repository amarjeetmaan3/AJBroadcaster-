package com.amarjeetmaan.ajbroadcaster.streaming.service

data class StreamingHealth(
    val networkAvailable: Boolean = false,
    val connected: Boolean = false,
    val streamActive: Boolean = false,
    val packetsSent: Long = 0L,
    val bytesSent: Long = 0L,
    val reconnectAttempts: Int = 0,
    val lastError: String? = null
) {

    val healthy: Boolean
        get() =
            networkAvailable &&
                connected &&
                streamActive &&
                lastError == null

    fun withError(
        message: String
    ): StreamingHealth {

        return copy(
            lastError = message
        )
    }

    fun clearError():
        StreamingHealth {

        return copy(
            lastError = null
        )
    }
}
