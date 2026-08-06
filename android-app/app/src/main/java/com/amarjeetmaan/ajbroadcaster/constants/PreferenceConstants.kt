package com.amarjeetmaan.ajbroadcaster.constants

/**
 * SharedPreferences / DataStore keys.
 *
 * Rules:
 * - Never hardcode preference keys.
 * - All local storage keys belong here.
 * - Keep only constant values in this file.
 */
object PreferenceConstants {

    // ==========================================================
    // Preference File
    // ==========================================================

    const val PREF_NAME = "aj_broadcaster_preferences"

    // ==========================================================
    // User
    // ==========================================================

    const val USER_ID = "user_id"

    const val USER_NAME = "user_name"

    const val USER_EMAIL = "user_email"

    const val USER_TOKEN = "user_token"

    const val USER_LOGGED_IN = "user_logged_in"

    // ==========================================================
    // Application
    // ==========================================================

    const val FIRST_LAUNCH = "first_launch"

    const val APP_LANGUAGE = "app_language"

    const val THEME_MODE = "theme_mode"

    const val KEEP_SCREEN_ON = "keep_screen_on"

    // ==========================================================
    // Streaming
    // ==========================================================

    const val LAST_STREAM_KEY = "last_stream_key"

    const val LAST_STREAM_URL = "last_stream_url"

    const val STREAM_QUALITY = "stream_quality"

    // ==========================================================
    // Tournament
    // ==========================================================

    const val LAST_TOURNAMENT_ID = "last_tournament_id"

    const val LAST_MATCH_ID = "last_match_id"

    const val LAST_TEAM_ID = "last_team_id"

    // ==========================================================
    // Director
    // ==========================================================

    const val DIRECTOR_MODE = "director_mode"

    // ==========================================================
    // Notifications
    // ==========================================================

    const val NOTIFICATIONS_ENABLED = "notifications_enabled"

    // ==========================================================
    // Debug
    // ==========================================================

    const val DEVELOPER_MODE = "developer_mode"
}
