package com.amarjeetmaan.ajbroadcaster.graphics

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.Graphics
import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import com.amarjeetmaan.ajbroadcaster.manager.GraphicsManager
import com.amarjeetmaan.ajbroadcaster.repository.GraphicsRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Central graphics engine.
 *
 * Coordinates:
 * - graphics configuration
 * - overlay visibility
 * - rendering
 * - animation
 * - layer ordering
 * - graphic events
 */
@Singleton
class GraphicsEngine @Inject constructor(
    private val repository: GraphicsRepository,
    private val graphicsManager: GraphicsManager,
    private val renderer: GraphicRenderer,
    private val animationManager: GraphicAnimationManager,
    private val layerManager: GraphicLayerManager,
    private val eventManager: GraphicEventManager
) {

    val activeOverlay: StateFlow<Overlay?>
        get() = graphicsManager.activeOverlay

    val graphics: StateFlow<Graphics?>
        get() = graphicsManager.graphics

    /**
     * Loads a graphics profile.
     */
    suspend fun loadGraphics(
        graphicsId: String
    ): AppResult<Graphics> {

        if (graphicsId.isBlank()) {
            return AppResult.Failure(
                IllegalArgumentException(
                    "Graphics ID is required."
                )
            )
        }

        return when (
            val result = repository.getGraphics(graphicsId)
        ) {
            is AppResult.Success -> {
                graphicsManager.updateGraphics(result.data)
                result
            }

            is AppResult.Failure -> result
        }
    }

    /**
     * Displays an overlay.
     */
    suspend fun show(
        overlay: Overlay
    ): AppResult<Unit> {

        if (overlay.id.isBlank()) {
            return AppResult.Failure(
                IllegalArgumentException(
                    "Overlay ID is required."
                )
            )
        }

        val orderedOverlay =
            layerManager.addOrUpdate(overlay)

        val repositoryResult =
            repository.updateOverlay(
                orderedOverlay.copy(
                    isVisible = true,
                    status = "Active",
                    updatedAt =
                        System.currentTimeMillis()
                )
            )

        if (repositoryResult is AppResult.Failure) {
            return repositoryResult
        }

        graphicsManager.showOverlay(
            orderedOverlay.copy(
                isVisible = true,
                status = "Active"
            )
        )

        animationManager.playIn(
            orderedOverlay.animation
        )

        eventManager.emit(
            GraphicEvent.Shown(
                orderedOverlay.id
            )
        )

        return AppResult.Success(Unit)
    }

    /**
     * Hides an overlay.
     */
    suspend fun hide(
        overlayId: String
    ): AppResult<Unit> {

        if (overlayId.isBlank()) {
            return AppResult.Failure(
                IllegalArgumentException(
                    "Overlay ID is required."
                )
            )
        }

        val result =
            repository.hideOverlay(
                overlayId
            )

        if (result is AppResult.Failure) {
            return result
        }

        animationManager.playOut()

        graphicsManager.hideOverlay()

        layerManager.remove(
            overlayId
        )

        eventManager.emit(
            GraphicEvent.Hidden(
                overlayId
            )
        )

        return AppResult.Success(Unit)
    }

    /**
     * Renders the currently active overlay.
     */
    fun renderActive(): RenderedGraphic? {
        val overlay =
            graphicsManager.activeOverlay.value
                ?: return null

        return renderer.render(
            overlay
        )
    }

    /**
     * Clears the complete graphics engine.
     */
    fun clear() {
        graphicsManager.clearGraphics()
        layerManager.clear()
        animationManager.stop()
        eventManager.emit(
            GraphicEvent.Cleared
        )
    }
}
