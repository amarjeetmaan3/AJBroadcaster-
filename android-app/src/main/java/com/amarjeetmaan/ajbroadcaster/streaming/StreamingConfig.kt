package com.amarjeetmaan.ajbroadcaster.streaming

data class StreamingConfig(
    val url: String,
    val streamKey: String,
    val protocol: StreamingProtocol = StreamingProtocol.RTMP,
    val reconnectEnabled: Boolean = true,
    val maxReconnectAttempts: Int = 5
) {

    init {
        require(url.isNotBlank()) {
            "Streaming URL is required."
        }

        require(streamKey.isNotBlank()) {
            "Stream key is required."
        }

        require(maxReconnectAttempts >= 0) {
            "Reconnect attempts cannot be negative."
        }
    }
}

enum class StreamingProtocol {
    RTMP,
    RTMPS,
    SRT
}
