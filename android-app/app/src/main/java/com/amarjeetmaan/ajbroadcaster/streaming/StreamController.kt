package com.amarjeetmaan.ajbroadcaster.streaming

import com.amarjeetmaan.ajbroadcaster.data.model.StreamSession
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * High-level controller for streaming operations.
 *
 * UI/ViewModels should communicate with this controller
 * instead of directly controlling the RTMP engine.
 */
@Singleton
class StreamController @Inject constructor(
    private val streamingEngine: StreamingEngine
) {

    val state: StateFlow<StreamState>
        get() = streamingEngine.state

    /**
     * Starts streaming.
     */
    suspend fun start(
        session: StreamSession
    ): Result<Unit> {
        return streamingEngine.start(session)
    }

    /**
     * Stops streaming.
     */
    suspend fun stop(): Result<Unit> {
        return streamingEngine.stop()
    }

    /**
     * Reconnects the stream.
     */
    suspend fun reconnect(): Result<Unit> {
        return streamingEngine.reconnect()
    }

    /**
     * Changes video bitrate.
     */
    suspend fun setBitrate(
        bitrateKbps: Int
    ): Result<Unit> {
        return streamingEngine.updateBitrate(
            bitrateKbps
        )
    }

    /**
     * Releases streaming resources.
     */
    suspend fun release() {
        streamingEngine.release()
    }
}
