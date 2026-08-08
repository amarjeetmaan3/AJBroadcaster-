package com.amarjeetmaan.ajbroadcaster.graphics

import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Represents the renderable result of an overlay.
 *
 * The actual Android Canvas / video-frame renderer can consume
 * this object later without changing the graphics domain layer.
 */
data class RenderedGraphic(
    val overlayId: String,
    val type: String,
    val x: Float,
    val y: Float,
    val width: Float,
    val height: Float,
    val opacity: Float,
    val zIndex: Int,
    val visible: Boolean
)

/**
 * Converts an Overlay model into render instructions.
 */
@Singleton
class GraphicRenderer @Inject constructor() {

    fun render(
        overlay: Overlay
    ): RenderedGraphic {

        return RenderedGraphic(
            overlayId = overlay.id,
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
            visible = overlay.isVisible
        )
    }

    fun renderAll(
        overlays: List<Overlay>
    ): List<RenderedGraphic> {

        return overlays
            .filter { it.isVisible }
            .sortedBy { it.zIndex }
            .map(::render)
    }
}
