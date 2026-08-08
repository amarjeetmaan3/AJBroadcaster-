package com.amarjeetmaan.ajbroadcaster.streaming

sealed class StreamingState {

    data object Idle : StreamingState()

    data class Configured(
        val config: StreamingConfig
    ) : StreamingState()

    data class Connecting(
        val config: StreamingConfig
    ) : StreamingState()

    data class Connected(
        val config: StreamingConfig
    ) : StreamingState()

    data class Live(
        val config: StreamingConfig,
        val packetsSent: Long = 0L
    ) : StreamingState()

    data class Error(
        val message: String
    ) : StreamingState()
}
