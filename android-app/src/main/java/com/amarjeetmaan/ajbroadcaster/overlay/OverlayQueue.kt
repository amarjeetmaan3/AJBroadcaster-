package com.amarjeetmaan.ajbroadcaster.overlay

import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import java.util.ArrayDeque
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Sequential queue for broadcast overlays.
 *
 * Useful for:
 * - wicket animation
 * - boundary animation
 * - player cards
 * - sponsor messages
 * - result graphics
 */
@Singleton
class OverlayQueue @Inject constructor() {

    private val queue =
        ArrayDeque<Overlay>()

    /**
     * Adds an overlay.
     */
    fun enqueue(
        overlay: Overlay
    ) {
        queue.addLast(
            overlay
        )
    }

    /**
     * Adds multiple overlays.
     */
    fun enqueueAll(
        overlays: List<Overlay>
    ) {
        overlays.forEach {
            enqueue(it)
        }
    }

    /**
     * Gets and removes next overlay.
     */
    fun next(): Overlay? {

        return if (queue.isEmpty()) {
            null
        } else {
            queue.removeFirst()
        }
    }

    /**
     * Looks at the next overlay.
     */
    fun peek(): Overlay? {
        return queue.firstOrNull()
    }

    /**
     * Removes a particular overlay.
     */
    fun remove(
        overlayId: String
    ): Boolean {

        val item =
            queue.firstOrNull {
                it.id == overlayId
            }

        return if (item != null) {
            queue.remove(item)
            true
        } else {
            false
        }
    }

    /**
     * Number of queued overlays.
     */
    fun size(): Int {
        return queue.size
    }

    /**
     * Whether the queue is empty.
     */
    fun isEmpty(): Boolean {
        return queue.isEmpty()
    }

    /**
     * Returns a queue snapshot.
     */
    fun snapshot(): List<Overlay> {
        return queue.toList()
    }

    /**
     * Clears all queued overlays.
     */
    fun clear() {
        queue.clear()
    }
}
