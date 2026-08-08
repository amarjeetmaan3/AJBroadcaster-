package com.amarjeetmaan.ajbroadcaster.overlay

import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Central engine for the broadcast overlay system.
 *
 * The engine coordinates:
 * - overlay visibility
 * - rendering
 * - layer ordering
 * - animations
 * - timed overlays
 * - overlay events
 *
 * Cricket calculations and Firebase operations do not belong here.
 */
@Singleton
class OverlayEngine @Inject constructor(
    private val renderer: OverlayRenderer,
    private val layerManager: OverlayLayerManager,
    private val animationManager: OverlayAnimationManager,
    private val queue: OverlayQueue
) {

    private val controller =
        OverlayController(
            renderer = renderer,
            layerManager = layerManager,
            animationManager = animationManager
        )

    val layers: StateFlow<List<Overlay>>
        get() = layerManager.layers

    val state: StateFlow<OverlayState>
        get() = controller.state

    /**
     * Shows an overlay immediately.
     */
    fun show(
        overlay: Overlay
    ): Result<Overlay> {

        if (overlay.id.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Overlay ID cannot be empty."
                )
            )
        }

        val result =
            controller.show(overlay)

        if (result.isSuccess) {
            queue.remove(overlay.id)
        }

        return result
    }

    /**
     * Hides an overlay.
     */
    fun hide(
        overlayId: String
    ): Result<Unit> {
        return controller.hide(
            overlayId
        )
    }

    /**
     * Adds an overlay to the timed queue.
     */
    fun enqueue(
        overlay: Overlay
    ) {
        queue.enqueue(overlay)
    }

    /**
     * Displays the next queued overlay.
     */
    fun showNext(): Result<Overlay?> {

        val next =
            queue.next()
                ?: return Result.success(null)

        val result =
            show(next)

        return if (result.isSuccess) {
            Result.success(next)
        } else {
            result.map { null }
        }
    }

    /**
     * Renders all currently visible layers.
     */
    fun render(): List<RenderedOverlay> {
        return renderer.renderAll(
            layerManager.visibleLayers()
        )
    }

    /**
     * Stops all active animations.
     */
    fun stopAnimations() {
        animationManager.stop()
    }

    /**
     * Clears the complete overlay engine.
     */
    fun clear() {
        animationManager.stop()
        queue.clear()
        layerManager.clear()
        controller.clear()
    }
}
