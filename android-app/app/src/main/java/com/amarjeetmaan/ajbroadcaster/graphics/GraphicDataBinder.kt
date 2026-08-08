package com.amarjeetmaan.ajbroadcaster.graphics

import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Converts a reusable graphic template plus runtime data
 * into an Overlay model.
 *
 * Runtime data is intentionally represented as a Map so this
 * layer can support score, player, team and tournament data
 * without coupling the renderer to one particular model.
 */
@Singleton
class GraphicDataBinder @Inject constructor() {

    /**
     * Creates an Overlay from a template.
     */
    fun bind(
        template: GraphicTemplate,
        data: Map<String, Any?>
    ): Overlay {

        val x =
            number(
                data["positionX"]
            ) ?: template.defaultX

        val y =
            number(
                data["positionY"]
            ) ?: template.defaultY

        val width =
            number(
                data["width"]
            ) ?: template.defaultWidth

        val height =
            number(
                data["height"]
            ) ?: template.defaultHeight

        val opacity =
            (
                number(
                    data["opacity"]
                ) ?: template.defaultOpacity
            ).coerceIn(
                0f,
                1f
            )

        val duration =
            long(
                data["duration"]
            ) ?: template.defaultDuration

        val zIndex =
            int(
                data["zIndex"]
            ) ?: template.defaultZIndex

        val animation =
            data["animation"]
                ?.toString()
                ?.takeIf {
                    it.isNotBlank()
                }
                ?: template.defaultAnimation

        return Overlay(
            id =
                data["id"]
                    ?.toString()
                    ?.takeIf {
                        it.isNotBlank()
                    }
                    ?: template.id,

            name =
                data["name"]
                    ?.toString()
                    ?.takeIf {
                        it.isNotBlank()
                    }
                    ?: template.name,

            type = template.type,

            isVisible =
                boolean(
                    data["isVisible"]
                ) ?: false,

            positionX = x,
            positionY = y,
            width = width,
            height = height,
            opacity = opacity,
            animation = animation,
            duration = duration,
            zIndex = zIndex,

            status =
                data["status"]
                    ?.toString()
                    ?: "Hidden",

            updatedAt =
                System.currentTimeMillis()
        )
    }

    private fun number(
        value: Any?
    ): Float? {
        return when (value) {
            is Float -> value
            is Double -> value.toFloat()
            is Int -> value.toFloat()
            is Long -> value.toFloat()
            is Number -> value.toFloat()
            else -> null
        }
    }

    private fun int(
        value: Any?
    ): Int? {
        return when (value) {
            is Number -> value.toInt()
            else -> null
        }
    }

    private fun long(
        value: Any?
    ): Long? {
        return when (value) {
            is Number -> value.toLong()
            else -> null
        }
    }

    private fun boolean(
        value: Any?
    ): Boolean? {
        return value as? Boolean
    }
}
