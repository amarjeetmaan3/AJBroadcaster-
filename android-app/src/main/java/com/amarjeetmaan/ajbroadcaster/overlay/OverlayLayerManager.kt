package com.amarjeetmaan.ajbroadcaster.overlay

import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Manages overlay layers and z-order.
 */
@Singleton
class OverlayLayerManager @Inject constructor() {

    private val items =
        LinkedHashMap<String, Overlay>()

    private val _layers =
        MutableStateFlow<List<Overlay>>(
            emptyList()
        )

    val layers: StateFlow<List<Overlay>>
        get() = _layers

    /**
     * Adds or updates an overlay.
     */
    fun addOrUpdate(
        overlay: Overlay
    ) {

        items[overlay.id] =
            overlay

        publish()
    }

    /**
     * Finds an overlay.
     */
    fun find(
        overlayId: String
    ): Overlay? {
        return items[overlayId]
    }

    /**
     * Removes an overlay.
     */
    fun remove(
        overlayId: String
    ): Boolean {

        val removed =
            items.remove(
                overlayId
            ) != null

        if (removed) {
            publish()
        }

        return removed
    }

    /**
     * Returns overlays sorted by z-index.
     */
    fun orderedLayers():
        List<Overlay> {

        return items.values
            .sortedBy {
                it.zIndex
            }
    }

    /**
     * Returns only visible overlays.
     */
    fun visibleLayers():
        List<Overlay> {

        return orderedLayers()
            .filter {
                it.isVisible
            }
    }

    /**
     * Changes layer order.
     */
    fun setZIndex(
        overlayId: String,
        zIndex: Int
    ): Boolean {

        val overlay =
            items[overlayId]
                ?: return false

        items[overlayId] =
            overlay.copy(
                zIndex = zIndex,
                updatedAt =
                    System.currentTimeMillis()
            )

        publish()

        return true
    }

    /**
     * Clears every overlay layer.
     */
    fun clear() {

        items.clear()
        publish()
    }

    private fun publish() {
        _layers.value =
            orderedLayers()
    }
}
