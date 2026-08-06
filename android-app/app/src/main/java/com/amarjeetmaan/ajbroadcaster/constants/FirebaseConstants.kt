package com.amarjeetmaan.ajbroadcaster.constants

/**
 * Firebase Realtime Database node names.
 *
 * Rules:
 * - Never hardcode Firebase paths anywhere else.
 * - Always reference these constants.
 * - New nodes must be added here.
 */
object FirebaseConstants {

    // ==========================================================
    // Root Nodes
    // ==========================================================

    const val USERS = "users"

    const val TOURNAMENTS = "tournaments"

    const val MATCHES = "matches"

    const val TEAMS = "teams"

    const val PLAYERS = "players"

    const val SPONSORS = "sponsors"

    const val STREAMS = "streams"

    const val DIRECTOR = "director"

    const val SETTINGS = "settings"

    const val GRAPHICS = "graphics"

    const val OVERLAYS = "overlays"

    const val ANIMATIONS = "animations"

    const val NOTIFICATIONS = "notifications"

    // ==========================================================
    // Match Engine
    // ==========================================================

    const val INNINGS = "innings"

    const val OVERS = "overs"

    const val BALLS = "balls"

    const val SCOREBOARD = "scoreboard"

    const val LIVE_SCORE = "live_score"

    const val MATCH_EVENTS = "match_events"

    const val STATISTICS = "statistics"

    // ==========================================================
    // Tournament
    // ==========================================================

    const val FIXTURES = "fixtures"

    const val POINTS_TABLE = "points_table"

    const val AUCTION = "auction"

    const val RETENTION = "retention"

    // ==========================================================
    // Media
    // ==========================================================

    const val LOGOS = "logos"

    const val PHOTOS = "photos"

    const val VIDEOS = "videos"

    const val ASSETS = "assets"

    // ==========================================================
    // App
    // ==========================================================

    const val APP_CONFIG = "app_config"

    const val APP_VERSION = "app_version"
}
