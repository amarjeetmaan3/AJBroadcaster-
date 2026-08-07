package com.amarjeetmaan.ajbroadcaster.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.Graphics
import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import kotlinx.coroutines.flow.Flow

/**
 * Repository contract for broadcast graphics operations.
 *
 * Defines all data operations related to
 * graphics profiles and overlays.
 */
interface GraphicsRepository {

    /**
     * Returns graphics configuration.
     */
    suspend fun getGraphics(
        graphicsId: String
    ): AppResult<Graphics>

    /**
     * Observes graphics updates.
     */
    fun observeGraphics(
        graphicsId: String
    ): Flow<Graphics>

    /**
     * Updates graphics configuration.
     */
    suspend fun updateGraphics(
        graphics: Graphics
    ): AppResult<Unit>

    /**
     * Returns all overlays.
     */
    suspend fun getOverlays(): AppResult<List<Overlay>>

    /**
     * Observes overlay changes.
     */
    fun observeOverlays(): Flow<List<Overlay>>

    /**
     * Updates an overlay.
     */
    suspend fun updateOverlay(
        overlay: Overlay
    ): AppResult<Unit>

    /**
     * Shows an overlay.
     */
    suspend fun showOverlay(
        overlayId: String
    ): AppResult<Unit>

    /**
     * Hides an overlay.
     */
    suspend fun hideOverlay(
        overlayId: String
    ): AppResult<Unit>

    /**
     * Applies a graphics theme.
     */
    suspend fun applyTheme(
        themeName: String
    ): AppResult<Unit>
}
