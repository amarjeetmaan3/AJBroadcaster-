package com.amarjeetmaan.ajbroadcaster.encoder

sealed class EncoderState {

    data object Idle : EncoderState()

    data class Configured(
        val config: EncoderConfig
    ) : EncoderState()

    data class Running(
        val config: EncoderConfig,
        val encodedFrames: Long = 0L
    ) : EncoderState()

    data class Stopped(
        val config: EncoderConfig
    ) : EncoderState()

    data class Error(
        val message: String
    ) : EncoderState()
}
