package com.amarjeetmaan.ajbroadcaster.streaming

sealed class StreamingEvent {

    data object Configured : StreamingEvent()

    data object Connected : StreamingEvent()

    data object Started : StreamingEvent()

    data object Stopped : StreamingEvent()

    data object Disconnected : StreamingEvent()

    data class PacketSent(
        val type: StreamPacketType,
        val timestampUs: Long
    ) : StreamingEvent()

    data class Reconnecting(
        val attempt: Int
    ) : StreamingEvent()

    data class Error(
        val message: String
    ) : StreamingEvent()
}
