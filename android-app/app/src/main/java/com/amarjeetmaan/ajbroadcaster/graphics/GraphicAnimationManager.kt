package com.amarjeetmaan.ajbroadcaster.graphics

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Current animation state.
 */
data class GraphicAnimationState(
    val animationName: String = "None",
    val running: Boolean = false,
    val direction: String = "None"
)

/**
 * Controls graphic animation state.
 *
 * The actual frame-by-frame animation can later be attached
 * to the renderer without changing the controller API.
 */
@Singleton
class GraphicAnimationManager @Inject constructor() {

    private val _state =
        MutableStateFlow(
            GraphicAnimationState()
        )

    val state: StateFlow<GraphicAnimationState>
        get() = _state

    /**
     * Plays an entrance animation.
     */
    fun playIn(
        animationName: String
    ) {

        val name =
            animationName.ifBlank {
                "None"
            }

        if (name.equals(
                "None",
                ignoreCase = true
            )
        ) {
            _state.value =
                GraphicAnimationState(
                    animationName = "None",
                    running = false,
                    direction = "In"
                )
            return
        }

        _state.value =
            GraphicAnimationState(
                animationName = name,
                running = true,
                direction = "In"
            )
    }

    /**
     * Plays an exit animation.
     */
    fun playOut() {

        val current =
            _state.value.animationName

        _state.value =
            GraphicAnimationState(
                animationName = current,
                running = true,
                direction = "Out"
            )
    }

    /**
     * Stops current animation.
     */
    fun stop() {

        _state.value =
            GraphicAnimationState(
                animationName =
                    _state.value.animationName,
                running = false,
                direction =
                    _state.value.direction
            )
    }

    /**
     * Resets animation state.
     */
    fun reset() {
        _state.value =
            GraphicAnimationState()
    }
}
