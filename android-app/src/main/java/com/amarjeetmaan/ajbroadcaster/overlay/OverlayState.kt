package com.amarjeetmaan.ajbroadcaster.overlay

import com.amarjeetmaan.ajbroadcaster.data.model.Overlay

/**
 * Runtime state of the overlay system.
 */
sealed class OverlayState {

    /**
     * No active overlay.
     */
    data object Idle : OverlayState()

    /**
     * Overlay system is loading.
     */
    data object Loading : OverlayState()

    /**
     * An overlay is visible.
     */
    data class Visible(
        val overlay: Overlay
    ) : OverlayState()

    /**
     * An overlay is animating.
     */
    data class Animating(
        val overlay: Overlay,
        val animation: String,
        val direction: String
    ) : OverlayState()

    /**
     * Overlay was hidden.
     */
    data class Hidden(
        val overlayId: String
    ) : OverlayState()

    /**
     * Overlay operation failed.
     */
    data class Error(
        val message: String
    ) : OverlayState()

    /**
     * Overlay system has been cleared.
     */
    data object Cleared : OverlayState()
}
