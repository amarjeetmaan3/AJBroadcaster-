package com.amarjeetmaan.ajbroadcaster.graphics

import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import java.util.ArrayDeque
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Queue for sequential broadcast graphics.
 *
 * Useful for:
 * - wicket graphics
 * - boundary graphics
 * - player cards
 * - sponsor messages
 * - match announcements
 */
@Singleton
class GraphicQueue @Inject constructor() {

    private val queue =
        ArrayDeque<Overlay>()

    /**
     * Adds an overlay to the queue.
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
     * Gets and removes the next overlay.
     */
    fun next(): Overlay? {
        return if (queue.isEmpty()) {
            null
        } else {
            queue.removeFirst()
        }
    }

    /**
     * Looks at the next overlay without removing it.
     */
    fun peek(): Overlay? {
        return queue.firstOrNull()
    }

    /**
     * Removes a specific overlay.
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
     * Number of queued graphics.
     */
    fun size(): Int {
        return queue.size
    }

    /**
     * Whether queue is empty.
     */
    fun isEmpty(): Boolean {
        return queue.isEmpty()
    }

    /**
     * Clears the queue.
     */
    fun clear() {
        queue.clear()
    }

    /**
     * Returns a snapshot.
     */
    fun snapshot(): List<Overlay> {
        return queue.toList()
    }
}
