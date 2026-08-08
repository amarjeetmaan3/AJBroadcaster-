package com.amarjeetmaan.ajbroadcaster.audio

import kotlinx.coroutines.flow.StateFlow

class AudioEngine(
    private val controller: AudioController
) {

    val state: StateFlow<AudioState>
        get() = controller.state

    val events
        get() = controller.events

    fun start(): Result<Unit> {
        return controller.start()
    }

    fun stop(): Result<Unit> {
        return controller.stop()
    }

    fun mute(
        muted: Boolean
    ): Result<Unit> {
        return controller.mute(muted)
    }

    fun setGain(
        gain: Float
    ): Result<Unit> {
        return controller.setGain(gain)
    }
}
