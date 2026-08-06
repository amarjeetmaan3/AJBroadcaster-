package com.amarjeetmaan.ajbroadcaster.constants

/**
 * Standard Intent Extra Keys.
 *
 * Rules:
 * - Never hardcode intent extra names.
 * - Every extra key used across the app belongs here.
 * - Use these constants for Activities, Services and BroadcastReceivers.
 */
object IntentConstants {

    // ==========================================================
    // Tournament
    // ==========================================================

    const val EXTRA_TOURNAMENT_ID = "extra_tournament_id"

    const val EXTRA_TOURNAMENT_NAME = "extra_tournament_name"

    // ==========================================================
    // Match
    // ==========================================================

    const val EXTRA_MATCH_ID = "extra_match_id"

    const val EXTRA_MATCH_NAME = "extra_match_name"

    const val EXTRA_MATCH_TYPE = "extra_match_type"

    const val EXTRA_MATCH_STATUS = "extra_match_status"

    // ==========================================================
    // Team
    // ==========================================================

    const val EXTRA_TEAM_ID = "extra_team_id"

    const val EXTRA_TEAM_NAME = "extra_team_name"

    // ==========================================================
    // Player
    // ==========================================================

    const val EXTRA_PLAYER_ID = "extra_player_id"

    const val EXTRA_PLAYER_NAME = "extra_player_name"

    // ==========================================================
    // Stream
    // ==========================================================

    const val EXTRA_STREAM_ID = "extra_stream_id"

    const val EXTRA_STREAM_URL = "extra_stream_url"

    // ==========================================================
    // Director
    // ==========================================================

    const val EXTRA_DIRECTOR_MODE = "extra_director_mode"

    // ==========================================================
    // Graphics
    // ==========================================================

    const val EXTRA_GRAPHICS_TEMPLATE = "extra_graphics_template"

    // ==========================================================
    // Generic
    // ==========================================================

    const val EXTRA_TITLE = "extra_title"

    const val EXTRA_MESSAGE = "extra_message"

    const val EXTRA_POSITION = "extra_position"

    const val EXTRA_RESULT = "extra_result"
}
