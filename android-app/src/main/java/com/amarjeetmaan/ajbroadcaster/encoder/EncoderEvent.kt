package com.amarjeetmaan.ajbroadcaster.encoder

sealed class EncoderEvent {

    data class Configured(
        val codec: EncoderCodec
    ) : EncoderEvent()

    data class Started(
        val codec: EncoderCodec
    ) : EncoderEvent()

    data object Stopped : EncoderEvent()

    data class PacketEncoded(
        val type: EncoderFrameType,
        val timestampUs: Long
    ) : EncoderEvent()

    data class Flushed(
        val packetCount: Int
    ) : EncoderEvent()

    data object Released : EncoderEvent()

    data class Error(
        val message: String
    ) : EncoderEvent()
}
