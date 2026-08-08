package com.amarjeetmaan.ajbroadcaster.overlay

import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Render-ready representation of an overlay.
 *
 * This class deliberately does not depend on Android Canvas.
 * A future Canvas/OpenGL/Compose renderer can consume this data.
 */
data class RenderedOverlay(
    val id: String,
    val name: String,
    val type: String,
    val x: Float,
    val y: Float,
    val width: Float,
    val height: Float,
    val opacity: Float,
    val zIndex: Int,
    val visible: Boolean,
    val animation: String
)

/**
 * Converts Overlay models into render instructions.
 */
@Singleton
class OverlayRenderer @Inject constructor() {

    /**
     * Converts one overlay.
     */
    fun render(
        overlay: Overlay
    ): RenderedOverlay {

        return RenderedOverlay(
            id = overlay.id,
            name = overlay.name,
            type = overlay.type,
            x = overlay.positionX,
            y = overlay.positionY,
            width = overlay.width,
            height = overlay.height,
            opacity = overlay.opacity.coerceIn(
                0f,
                1f
            ),
            zIndex = overlay.zIndex,
            visible = overlay.isVisible,
            animation = overlay.animation
        )
    }

    /**
     * Converts multiple overlays.
     *
     * Lowest z-index is rendered first.
     */
    fun renderAll(
        overlays: List<Overlay>
    ): List<RenderedOverlay> {

        return overlays
            .filter {
                it.isVisible
            }
            .sortedBy {
                it.zIndex
            }
            .map(::render)
    }
}
