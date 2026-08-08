package com.amarjeetmaan.ajbroadcaster.overlay

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Runtime state of overlay animation.
 */
data class OverlayAnimationState(
    val animation: String = "None",
    val running: Boolean = false,
    val direction: String = "None"
)

/**
 * Controls overlay animation state.
 *
 * The actual rendering engine can later consume this state
 * for frame-by-frame animation.
 */
@Singleton
class OverlayAnimationManager @Inject constructor() {

    private val _state =
        MutableStateFlow(
            OverlayAnimationState()
        )

    val state: StateFlow<OverlayAnimationState>
        get() = _state

    /**
     * Starts entrance animation.
     */
    fun playIn(
        animation: String
    ) {

        val name =
            animation.ifBlank {
                "None"
            }

        _state.value =
            OverlayAnimationState(
                animation = name,
                running =
                    !name.equals(
                        "None",
                        ignoreCase = true
                    ),
                direction = "In"
            )
    }

    /**
     * Starts exit animation.
     */
    fun playOut(
        animation: String = _state.value.animation
    ) {

        val name =
            animation.ifBlank {
                "None"
            }

        _state.value =
            OverlayAnimationState(
                animation = name,
                running =
                    !name.equals(
                        "None",
                        ignoreCase = true
                    ),
                direction = "Out"
            )
    }

    /**
     * Stops animation.
     */
    fun stop() {

        _state.value =
            _state.value.copy(
                running = false
            )
    }

    /**
     * Resets animation state.
     */
    fun reset() {
        _state.value =
            OverlayAnimationState()
    }
}
