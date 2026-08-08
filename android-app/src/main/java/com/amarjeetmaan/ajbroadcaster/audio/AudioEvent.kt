package com.amarjeetmaan.ajbroadcaster.audio

sealed class AudioEvent {

    data object Started : AudioEvent()

    data object Stopped : AudioEvent()

    data class MuteChanged(
        val muted: Boolean
    ) : AudioEvent()

    data class GainChanged(
        val gain: Float
    ) : AudioEvent()

    data class SourceAdded(
        val sourceId: String
    ) : AudioEvent()

    data class SourceRemoved(
        val sourceId: String
    ) : AudioEvent()

    data class Error(
        val message: String
    ) : AudioEvent()
}
