package com.amarjeetmaan.ajbroadcaster.streaming

import com.amarjeetmaan.ajbroadcaster.data.model.StreamSession
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Core streaming engine.
 *
 * Coordinates the RTMP connection and exposes
 * the current streaming state.
 *
 * This class does not own the UI.
 */
@Singleton
class StreamingEngine @Inject constructor(
    private val rtmpStreamManager: RtmpStreamManager,
    private val streamSessionManager: StreamSessionManager
) {

    val state: StateFlow<StreamState>
        get() = streamSessionManager.state

    /**
     * Starts a streaming session.
     */
    suspend fun start(
        session: StreamSession
    ): Result<Unit> {

        if (session.rtmpUrl.isBlank()) {
            return Result.failure(
                IllegalArgumentException("RTMP URL is required.")
            )
        }

        if (session.streamKey.isBlank()) {
            return Result.failure(
                IllegalArgumentException("Stream key is required.")
            )
        }

        val config = StreamConfig.fromSession(session)

        streamSessionManager.setConnecting(session)

        return try {
            rtmpStreamManager.connect(config)

            streamSessionManager.setLive(
                session.copy(
                    status = "Live",
                    startedAt = System.currentTimeMillis(),
                    updatedAt = System.currentTimeMillis()
                )
            )

            Result.success(Unit)
        } catch (exception: Exception) {
            streamSessionManager.setFailed(exception.message)

            Result.failure(exception)
        }
    }

    /**
     * Stops the current stream.
     */
    suspend fun stop(): Result<Unit> {
        return try {
            rtmpStreamManager.disconnect()

            streamSessionManager.setStopped()

            Result.success(Unit)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /**
     * Changes video bitrate.
     */
    suspend fun updateBitrate(
        bitrateKbps: Int
    ): Result<Unit> {

        if (bitrateKbps <= 0) {
            return Result.failure(
                IllegalArgumentException(
                    "Bitrate must be greater than zero."
                )
            )
        }

        return try {
            rtmpStreamManager.setBitrate(
                bitrateKbps
            )

            streamSessionManager.updateBitrate(
                bitrateKbps
            )

            Result.success(Unit)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /**
     * Attempts to reconnect.
     */
    suspend fun reconnect(): Result<Unit> {
        return try {
            rtmpStreamManager.reconnect()

            streamSessionManager.setReconnecting()

            Result.success(Unit)
        } catch (exception: Exception) {
            streamSessionManager.setFailed(
                exception.message
            )

            Result.failure(exception)
        }
    }

    /**
     * Releases engine resources.
     */
    suspend fun release() {
        runCatching {
            rtmpStreamManager.disconnect()
        }

        streamSessionManager.clear()
    }
}
