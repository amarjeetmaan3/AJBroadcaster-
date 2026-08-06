package com.amarjeetmaan.ajbroadcaster.constants

/**
 * Global application constants.
 *
 * Rules:
 * - Only application-wide constants belong here.
 * - Do not store Firebase paths, Intent keys, or Preference keys here.
 * - Do not place business logic in this file.
 */
object AppConstants {

    // ==========================================================
    // Application
    // ==========================================================

    const val APP_NAME = "AJ Broadcaster"

    const val VERSION_NAME = "1.0.0"

    const val VERSION_CODE = 1

    // ==========================================================
    // Logging
    // ==========================================================

    const val LOG_TAG = "AJBroadcaster"

    // ==========================================================
    // Timeouts
    // ==========================================================

    const val DEFAULT_TIMEOUT_MS = 30_000L

    const val DEFAULT_ANIMATION_DURATION_MS = 300L

    // ==========================================================
    // Database
    // ==========================================================

    const val DATABASE_VERSION = 1

    const val SCHEMA_VERSION = 1

    // ==========================================================
    // Generic Values
    // ==========================================================

    const val EMPTY = ""

    const val UNKNOWN = "unknown"

    const val NOT_AVAILABLE = "N/A"

    // ==========================================================
    // Boolean Flags
    // ==========================================================

    const val ENABLE_LOGS = true
}
