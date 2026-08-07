package com.amarjeetmaan.ajbroadcaster.data.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.AppSettings
import com.amarjeetmaan.ajbroadcaster.repository.SettingsRepository
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Firebase implementation of SettingsRepository.
 *
 * NOTE:
 * This is the initial implementation.
 * Firebase synchronization logic will
 * be added in future phases.
 */
class FirebaseSettingsRepository(
    private val database: FirebaseDatabase
) : SettingsRepository {

    private val settingsRef =
        database.getReference("settings")

    override suspend fun getSettings(): AppResult<AppSettings> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override fun observeSettings(): Flow<AppSettings> = flow {
        // Firebase listener will be added later.
    }

    override suspend fun saveSettings(
        settings: AppSettings
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun resetSettings(): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun updateTheme(
        theme: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun updateLanguage(
        language: String
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun setNotificationsEnabled(
        enabled: Boolean
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun setAutoRecording(
        enabled: Boolean
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }

    override suspend fun setGraphicsEnabled(
        enabled: Boolean
    ): AppResult<Unit> {
        return AppResult.Error(
            UnsupportedOperationException("Not implemented yet.")
        )
    }
}
