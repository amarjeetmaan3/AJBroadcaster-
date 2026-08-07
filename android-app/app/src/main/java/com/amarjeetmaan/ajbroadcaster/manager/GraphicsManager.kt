package com.amarjeetmaan.ajbroadcaster.manager

import com.amarjeetmaan.ajbroadcaster.data.model.Graphics
import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Manages broadcast graphics and overlays.
 *
 * Responsible for scoreboard graphics,
 * animations, sponsor banners,
 * player cards, match summaries,
 * and overlay visibility.
 *
 * Rendering logic will be added
 * in future phases.
 */
@Singleton
class GraphicsManager @Inject constructor() {

    private val _activeOverlay =
        MutableStateFlow<Overlay?>(null)

    private val _graphics =
        MutableStateFlow<Graphics?>(null)

    /**
     * Emits the active overlay.
     */
    val activeOverlay: StateFlow<Overlay?>
        get() = _activeOverlay

    /**
     * Emits the current graphics configuration.
     */
    val graphics: StateFlow<Graphics?>
        get() = _graphics

    /**
     * Updates graphics configuration.
     */
    fun updateGraphics(
        graphics: Graphics
    ) {
        _graphics.value = graphics
    }

    /**
     * Displays an overlay.
     */
    fun showOverlay(
        overlay: Overlay
    ) {
        _activeOverlay.value = overlay
    }

    /**
     * Hides the current overlay.
     */
    fun hideOverlay() {
        _activeOverlay.value = null
    }

    /**
     * Plays a graphics animation.
     *
     * Placeholder implementation.
     */
    fun playAnimation(
        animationName: String
    ) {
        // Reserved for future implementation.
    }

    /**
     * Clears all graphics.
     */
    fun clearGraphics() {
        _graphics.value = null
        _activeOverlay.value = null
    }
}
