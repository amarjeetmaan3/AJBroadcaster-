package com.amarjeetmaan.ajbroadcaster.repository

import com.amarjeetmaan.ajbroadcaster.core.AppResult
import com.amarjeetmaan.ajbroadcaster.data.model.AppSettings
import kotlinx.coroutines.flow.Flow

/**
 * Repository contract for application settings.
 *
 * Defines all operations related to user preferences
 * and application configuration.
 */
interface SettingsRepository {

    /**
     * Returns application settings.
     */
    suspend fun getSettings(): AppResult<AppSettings>

    /**
     * Observes settings changes.
     */
    fun observeSettings(): Flow<AppSettings>

    /**
     * Saves application settings.
     */
    suspend fun saveSettings(
        settings: AppSettings
    ): AppResult<Unit>

    /**
     * Resets settings to default values.
     */
    suspend fun resetSettings(): AppResult<Unit>

    /**
     * Updates application theme.
     */
    suspend fun updateTheme(
        theme: String
    ): AppResult<Unit>

    /**
     * Updates application language.
     */
    suspend fun updateLanguage(
        language: String
    ): AppResult<Unit>

    /**
     * Enables or disables notifications.
     */
    suspend fun setNotificationsEnabled(
        enabled: Boolean
    ): AppResult<Unit>

    /**
     * Enables or disables automatic recording.
     */
    suspend fun setAutoRecording(
        enabled: Boolean
    ): AppResult<Unit>

    /**
     * Enables or disables broadcast graphics.
     */
    suspend fun setGraphicsEnabled(
        enabled: Boolean
    ): AppResult<Unit>
}
