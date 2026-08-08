package com.amarjeetmaan.ajbroadcaster.graphics

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import javax.inject.Inject
import javax.inject.Singleton

/**
 * High-level controller used by ViewModels and director controls.
 */
@Singleton
class GraphicController @Inject constructor(
    private val engine: GraphicsEngine,
    private val dataBinder: GraphicDataBinder
) {

    /**
     * Shows an overlay.
     */
    suspend fun show(
        overlay: Overlay
    ): AppResult<Unit> {

        return engine.show(
            overlay
        )
    }

    /**
     * Shows a template using runtime data.
     */
    suspend fun showTemplate(
        template: GraphicTemplate,
        data: Map<String, Any?>
    ): AppResult<Unit> {

        val overlay =
            dataBinder.bind(
                template = template,
                data = data
            )

        return engine.show(
            overlay
        )
    }

    /**
     * Hides an overlay.
     */
    suspend fun hide(
        overlayId: String
    ): AppResult<Unit> {

        return engine.hide(
            overlayId
        )
    }

    /**
     * Renders the active graphic.
     */
    fun renderActive(): RenderedGraphic? {
        return engine.renderActive()
    }

    /**
     * Clears all graphics.
     */
    fun clear() {
        engine.clear()
    }
}
