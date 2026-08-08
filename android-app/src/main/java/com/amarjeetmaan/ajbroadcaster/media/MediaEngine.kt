package com.amarjeetmaan.ajbroadcaster.media

import kotlinx.coroutines.flow.StateFlow

class MediaEngine(
    private val controller: MediaController
) {

    val state: StateFlow<MediaState>
        get() = controller.state

    val events
        get() = controller.events

    fun start(
        session: MediaSession
    ): Result<Unit> {
        return controller.start(session)
    }

    fun stop(): Result<Unit> {
        return controller.stop()
    }

    fun pause(): Result<Unit> {
        return controller.pause()
    }

    fun resume(): Result<Unit> {
        return controller.resume()
    }

    fun submitVideo(
        frame: MediaFrame
    ): Result<Unit> {
        return controller.submitVideo(frame)
    }

    fun submitAudio(
        frame: MediaFrame
    ): Result<Unit> {
        return controller.submitAudio(frame)
    }
}
