package com.amarjeetmaan.ajbroadcaster.data.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.StreamSession
import com.amarjeetmaan.ajbroadcaster.repository.StreamRepository
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Firebase implementation of StreamRepository.
 *
 * NOTE:
 * This is the initial implementation.
 * Streaming synchronization logic will
 * be added in future phases.
 */
class FirebaseStreamRepository(
    private val database: FirebaseDatabase
) : StreamRepository {

    private val streamsRef =
        database.getReference("streams")

    override suspend fun startStream(
        session: StreamSession
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun stopStream(
        sessionId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun updateStream(
        session: StreamSession
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun getStream(
        sessionId: String
    ): AppResult<StreamSession> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override fun observeStream(
        sessionId: String
    ): Flow<StreamSession> = flow {
        // Firebase listener will be added later.
    }

    override suspend fun reconnectStream(
        sessionId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun startRecording(
        sessionId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun stopRecording(
        sessionId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun updateBitrate(
        sessionId: String,
        bitrate: Int
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }
}
