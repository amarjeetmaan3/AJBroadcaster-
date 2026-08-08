package com.amarjeetmaan.ajbroadcaster.overlay

import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Internal state holder for OverlayController.
 */
internal class OverlayStateManager {

    private val _state =
        MutableStateFlow<OverlayState>(
            OverlayState.Idle
        )

    val state: StateFlow<OverlayState>
        get() = _state

    fun setVisible(
        overlay: Overlay
    ) {
        _state.value =
            OverlayState.Visible(
                overlay
            )
    }

    fun setHidden(
        overlayId: String
    ) {
        _state.value =
            OverlayState.Hidden(
                overlayId
            )
    }

    fun setError(
        message: String
    ) {
        _state.value =
            OverlayState.Error(
                message
            )
    }

    fun clear() {
        _state.value =
            OverlayState.Cleared
    }
}
