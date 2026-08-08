package com.amarjeetmaan.ajbroadcaster.overlay

import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Binds presentation data to an overlay template.
 *
 * It does not calculate cricket statistics.
 * It only receives already-calculated values.
 */
@Singleton
class OverlayDataBinder @Inject constructor() {

    /**
     * Creates an Overlay from a template.
     */
    fun bind(
        template: OverlayTemplate,
        data: Map<String, Any?>
    ): Overlay {

        return Overlay(
            id =
                string(
                    data["id"]
                ) ?: template.id,

            name =
                string(
                    data["name"]
                ) ?: template.name,

            type =
                template.type,

            isVisible =
                boolean(
                    data["isVisible"]
                ) ?: false,

            positionX =
                float(
                    data["positionX"]
                ) ?: template.positionX,

            positionY =
                float(
                    data["positionY"]
                ) ?: template.positionY,

            width =
                float(
                    data["width"]
                ) ?: template.width,

            height =
                float(
                    data["height"]
                ) ?: template.height,

            opacity =
                (
                    float(
                        data["opacity"]
                    ) ?: template.opacity
                ).coerceIn(
                    0f,
                    1f
                ),

            animation =
                string(
                    data["animation"]
                ) ?: template.animation,

            duration =
                long(
                    data["duration"]
                ) ?: template.duration,

            zIndex =
                int(
                    data["zIndex"]
                ) ?: template.zIndex,

            status =
                string(
                    data["status"]
                ) ?: "Hidden",

            updatedAt =
                System.currentTimeMillis()
        )
    }

    private fun string(
        value: Any?
    ): String? {
        return value
            ?.toString()
            ?.takeIf {
                it.isNotBlank()
            }
    }

    private fun boolean(
        value: Any?
    ): Boolean? {
        return value as? Boolean
    }

    private fun float(
        value: Any?
    ): Float? {
        return when (value) {
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
}
