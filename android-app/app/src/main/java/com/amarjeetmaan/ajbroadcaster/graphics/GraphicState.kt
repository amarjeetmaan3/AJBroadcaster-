package com.amarjeetmaan.ajbroadcaster.graphics

import com.amarjeetmaan.ajbroadcaster.data.model.Overlay

/**
 * Runtime state of the graphics engine.
 */
sealed class GraphicState {

    /**
     * Graphics engine has not been initialized.
     */
    data object Idle : GraphicState()

    /**
     * Graphics are loading.
     */
    data object Loading : GraphicState()

    /**
     * Graphics are ready.
     */
    data class Ready(
        val overlays: List<Overlay>
    ) : GraphicState()

    /**
     * An overlay is currently visible.
     */
    data class Showing(
        val overlay: Overlay
    ) : GraphicState()

    /**
     * Graphics operation failed.
     */
    data class Error(
        val message: String
    ) : GraphicState()

    /**
     * Graphics have been cleared.
     */
    data object Cleared : GraphicState()
}
