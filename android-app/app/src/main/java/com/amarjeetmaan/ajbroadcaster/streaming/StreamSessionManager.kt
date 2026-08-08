package com.amarjeetmaan.ajbroadcaster.streaming

import com.amarjeetmaan.ajbroadcaster.data.model.StreamSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Maintains the currently active stream session
 * and its runtime state.
 */
@Singleton
class StreamSessionManager @Inject constructor() {

    private var currentSession:
        StreamSession? = null

    private val _state =
        MutableStateFlow<StreamState>(
            StreamState.Idle
        )

    val state: StateFlow<StreamState>
        get() = _state

    /**
     * Sets a session into connecting state.
     */
    fun setConnecting(
        session: StreamSession
    ) {

        currentSession = session

        _state.value =
            StreamState.Connecting(
                session
            )
    }

    /**
     * Sets a session into live state.
     */
    fun setLive(
        session: StreamSession
    ) {

        currentSession = session

        _state.value =
            StreamState.Live(
                session
            )
    }

    /**
     * Sets reconnecting state.
     */
    fun setReconnecting() {

        _state.value =
            StreamState.Reconnecting(
                currentSession
            )
    }

    /**
     * Sets failed state.
     */
    fun setFailed(
        message: String?
    ) {

        _state.value =
            StreamState.Failed(
                session = currentSession,
                message =
                    message?.takeIf {
                        it.isNotBlank()
                    } ?: "Streaming failed."
            )
    }

    /**
     * Sets stopped state.
     */
    fun setStopped() {

        val previous =
            currentSession

        currentSession =
            previous?.copy(
                status = "Stopped",
                endedAt =
                    System.currentTimeMillis(),
                updatedAt =
                    System.currentTimeMillis()
            )

        _state.value =
            StreamState.Stopped(
                currentSession
            )
    }

    /**
     * Updates bitrate in current session.
     */
    fun updateBitrate(
        bitrateKbps: Int
    ) {

        currentSession =
            currentSession?.copy(
                videoBitrate = bitrateKbps,
                updatedAt =
                    System.currentTimeMillis()
            )

        val session =
            currentSession
                ?: return

        if (_state.value is StreamState.Live) {
            _state.value =
                StreamState.Live(session)
        }
    }

    /**
     * Returns active session.
     */
    fun getCurrentSession():
        StreamSession? {
        return currentSession
    }

    /**
     * Clears session state.
     */
    fun clear() {

        currentSession = null

        _state.value =
            StreamState.Idle
    }
}
