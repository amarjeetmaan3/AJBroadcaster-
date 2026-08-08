package com.amarjeetmaan.ajbroadcaster.streaming.service

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Platform-neutral network monitor.
 *
 * Android ConnectivityManager implementation
 * belongs in the platform layer.
 */
class NetworkMonitor {

    private val _state =
        MutableStateFlow(
            NetworkState()
        )

    val state: StateFlow<NetworkState>
        get() = _state

    fun update(
        connected: Boolean,
        type: NetworkType,
        metered: Boolean
    ) {

        _state.value =
            NetworkState(
                connected = connected,
                type = type,
                metered = metered
            )
    }

    fun isConnected(): Boolean {
        return _state.value.connected
    }

    fun reset() {
        _state.value =
            NetworkState()
    }
}
