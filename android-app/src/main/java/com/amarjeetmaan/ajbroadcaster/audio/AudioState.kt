package com.amarjeetmaan.ajbroadcaster.audio

data class AudioState(
    val running: Boolean = false,
    val muted: Boolean = false,
    val gain: Float = 1f,
    val sampleRate: Int = 48_000,
    val channels: Int = 2
)
