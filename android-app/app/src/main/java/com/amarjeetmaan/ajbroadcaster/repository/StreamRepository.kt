package com.amarjeetmaan.ajbroadcaster.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.StreamSession
import kotlinx.coroutines.flow.Flow

/**
 * Repository contract for live streaming operations.
 *
 * Defines all data operations related to
 * streaming sessions and broadcast state.
 */
interface StreamRepository {

    /**
     * Starts a streaming session.
     */
    suspend fun startStream(
        session: StreamSession
    ): AppResult<Unit>

    /**
     * Stops the current stream.
     */
    suspend fun stopStream(
        sessionId: String
    ): AppResult<Unit>

    /**
     * Updates streaming session.
     */
    suspend fun updateStream(
        session: StreamSession
    ): AppResult<Unit>

    /**
     * Returns a streaming session.
     */
    suspend fun getStream(
        sessionId: String
    ): AppResult<StreamSession>

    /**
     * Observes stream status.
     */
    fun observeStream(
        sessionId: String
    ): Flow<StreamSession>

    /**
     * Reconnects a failed stream.
     */
    suspend fun reconnectStream(
        sessionId: String
    ): AppResult<Unit>

    /**
     * Starts recording.
     */
    suspend fun startRecording(
        sessionId: String
    ): AppResult<Unit>

    /**
     * Stops recording.
     */
    suspend fun stopRecording(
        sessionId: String
    ): AppResult<Unit>

    /**
     * Updates stream bitrate.
     */
    suspend fun updateBitrate(
        sessionId: String,
        bitrate: Int
    ): AppResult<Unit>
}
