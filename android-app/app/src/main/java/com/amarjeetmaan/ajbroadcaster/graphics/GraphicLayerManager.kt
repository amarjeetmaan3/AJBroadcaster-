package com.amarjeetmaan.ajbroadcaster.graphics

import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Maintains graphic layers and z-order.
 */
@Singleton
class GraphicLayerManager @Inject constructor() {

    private val layers =
        LinkedHashMap<String, Overlay>()

    private val _layersState =
        MutableStateFlow<List<Overlay>>(
            emptyList()
        )

    val layersState: StateFlow<List<Overlay>>
        get() = _layersState

    /**
     * Adds or updates an overlay.
     */
    fun addOrUpdate(
        overlay: Overlay
    ): Overlay {

        layers[overlay.id] =
            overlay

        publish()

        return overlay
    }

    /**
     * Removes an overlay.
     */
    fun remove(
        overlayId: String
    ): Boolean {

        val removed =
            layers.remove(
                overlayId
            ) != null

        if (removed) {
            publish()
        }

        return removed
    }

    /**
     * Finds an overlay.
     */
    fun find(
        overlayId: String
    ): Overlay? {
        return layers[overlayId]
    }

    /**
     * Returns layers sorted by z-index.
     */
    fun getOrderedLayers():
        List<Overlay> {

        return layers.values
            .sortedBy {
                it.zIndex
            }
    }

    /**
     * Returns only visible layers.
     */
    fun getVisibleLayers():
        List<Overlay> {

        return getOrderedLayers()
            .filter {
                it.isVisible
            }
    }

    /**
     * Changes an overlay's z-index.
     */
    fun setZIndex(
        overlayId: String,
        zIndex: Int
    ): Boolean {

        val overlay =
            layers[overlayId]
                ?: return false

        layers[overlayId] =
            overlay.copy(
                zIndex = zIndex,
                updatedAt =
                    System.currentTimeMillis()
            )

        publish()

        return true
    }

    /**
     * Clears all layers.
     */
    fun clear() {

        layers.clear()
        publish()
    }

    private fun publish() {

        _layersState.value =
            getOrderedLayers()
    }
}
