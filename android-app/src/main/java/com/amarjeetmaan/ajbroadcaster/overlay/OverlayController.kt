package com.amarjeetmaan.ajbroadcaster.overlay

import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * High-level controller for overlay operations.
 *
 * UI/director code should use this class instead of directly
 * manipulating the layer manager.
 */
class OverlayController @Inject constructor(
    private val renderer: OverlayRenderer,
    private val layerManager: OverlayLayerManager,
    private val animationManager: OverlayAnimationManager
) {

    private val stateManager =
        OverlayStateManager()

    val state: StateFlow<OverlayState>
        get() = stateManager.state

    /**
     * Shows an overlay.
     */
    fun show(
        overlay: Overlay
    ): Result<Overlay> {

        if (overlay.id.isBlank()) {
            val error =
                IllegalArgumentException(
                    "Overlay ID cannot be empty."
                )

            stateManager.setError(
                error.message ?: "Invalid overlay."
            )

            return Result.failure(error)
        }

        val activeOverlay =
            overlay.copy(
                isVisible = true,
                status = "Active",
                updatedAt =
                    System.currentTimeMillis()
            )

        layerManager.addOrUpdate(
            activeOverlay
        )

        stateManager.setVisible(
            activeOverlay
        )

        animationManager.playIn(
            activeOverlay.animation
        )

        return Result.success(
            activeOverlay
        )
    }

    /**
     * Hides an overlay.
     */
    fun hide(
        overlayId: String
    ): Result<Unit> {

        if (overlayId.isBlank()) {
            return Result.failure(
                IllegalArgumentException(
                    "Overlay ID cannot be empty."
                )
            )
        }

        val overlay =
            layerManager.find(
                overlayId
            )

        if (overlay == null) {
            return Result.failure(
                NoSuchElementException(
                    "Overlay not found: $overlayId"
                )
            )
        }

        animationManager.playOut(
            overlay.animation
        )

        layerManager.addOrUpdate(
            overlay.copy(
                isVisible = false,
                status = "Hidden",
                updatedAt =
                    System.currentTimeMillis()
            )
        )

        stateManager.setHidden(
            overlayId
        )

        return Result.success(Unit)
    }

    /**
     * Updates an existing overlay.
     */
    fun update(
        overlay: Overlay
    ): Result<Overlay> {

        if (layerManager.find(
                overlay.id
            ) == null
        ) {
            return Result.failure(
                NoSuchElementException(
                    "Overlay not found: ${overlay.id}"
                )
            )
        }

        val updated =
            overlay.copy(
                updatedAt =
                    System.currentTimeMillis()
            )

        layerManager.addOrUpdate(
            updated
        )

        stateManager.setVisible(
            updated
        )

        return Result.success(
            updated
        )
    }

    /**
     * Renders the current visible overlays.
     */
    fun render():
        List<RenderedOverlay> {

        return renderer.renderAll(
            layerManager.visibleLayers()
        )
    }

    /**
     * Clears controller state.
     */
    fun clear() {
        stateManager.clear()
    }
}
