package com.amarjeetmaan.ajbroadcaster.graphics

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Event bus for graphics events.
 *
 * Used by:
 * - Director controls
 * - Graphics UI
 * - Overlay system
 * - Broadcast diagnostics
 */
@Singleton
class GraphicEventManager @Inject constructor() {

    private val _events =
        MutableSharedFlow<GraphicEvent>(
            replay = 0,
            extraBufferCapacity = 64
        )

    val events: SharedFlow<GraphicEvent>
        get() = _events

    /**
     * Emits a graphics event.
     */
    fun emit(
        event: GraphicEvent
    ) {
        _events.tryEmit(event)
    }
}
