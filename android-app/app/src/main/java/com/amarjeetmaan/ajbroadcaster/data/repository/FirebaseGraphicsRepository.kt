package com.amarjeetmaan.ajbroadcaster.data.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.Graphics
import com.amarjeetmaan.ajbroadcaster.data.model.Overlay
import com.amarjeetmaan.ajbroadcaster.repository.GraphicsRepository
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Firebase implementation of GraphicsRepository.
 *
 * NOTE:
 * This is the initial implementation.
 * Graphics synchronization logic will
 * be added in future phases.
 */
class FirebaseGraphicsRepository(
    private val database: FirebaseDatabase
) : GraphicsRepository {

    private val graphicsRef =
        database.getReference("graphics")

    private val overlaysRef =
        database.getReference("overlays")

    override suspend fun getGraphics(
        graphicsId: String
    ): AppResult<Graphics> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override fun observeGraphics(
        graphicsId: String
    ): Flow<Graphics> = flow {
        // Firebase listener will be added later.
    }

    override suspend fun updateGraphics(
        graphics: Graphics
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun getOverlays(): AppResult<List<Overlay>> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override fun observeOverlays(): Flow<List<Overlay>> = flow {
        // Firebase listener will be added later.
    }

    override suspend fun updateOverlay(
        overlay: Overlay
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun showOverlay(
        overlayId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun hideOverlay(
        overlayId: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun applyTheme(
        themeName: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }
}
