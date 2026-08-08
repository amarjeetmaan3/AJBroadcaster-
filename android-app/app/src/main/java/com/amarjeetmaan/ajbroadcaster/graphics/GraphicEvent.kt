package com.amarjeetmaan.ajbroadcaster.graphics

/**
 * Events produced by the graphics subsystem.
 */
sealed class GraphicEvent {

    /**
     * Graphics configuration loaded.
     */
    data class GraphicsLoaded(
        val graphicsId: String
    ) : GraphicEvent()

    /**
     * Overlay became visible.
     */
    data class Shown(
        val overlayId: String
    ) : GraphicEvent()

    /**
     * Overlay became hidden.
     */
    data class Hidden(
        val overlayId: String
    ) : GraphicEvent()

    /**
     * Overlay data changed.
     */
    data class Updated(
        val overlayId: String
    ) : GraphicEvent()

    /**
     * Animation started.
     */
    data class AnimationStarted(
        val overlayId: String,
        val animationName: String
    ) : GraphicEvent()

    /**
     * Animation finished.
     */
    data class AnimationFinished(
        val overlayId: String,
        val animationName: String
    ) : GraphicEvent()

    /**
     * Graphic rendering failed.
     */
    data class RenderFailed(
        val overlayId: String,
        val message: String
    ) : GraphicEvent()

    /**
     * Graphics were cleared.
     */
    data object Cleared : GraphicEvent()
}
