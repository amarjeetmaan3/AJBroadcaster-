package com.amarjeetmaan.ajbroadcaster.constants

import android.Manifest
import android.os.Build

/**
 * Android runtime permissions used by AJ Broadcaster.
 *
 * Rules:
 * - Never hardcode permission strings.
 * - Always reference this object.
 * - Add new permissions here only.
 */
object PermissionConstants {

    // ==========================================================
    // Camera
    // ==========================================================

    const val CAMERA = Manifest.permission.CAMERA

    // ==========================================================
    // Microphone
    // ==========================================================

    const val RECORD_AUDIO = Manifest.permission.RECORD_AUDIO

    // ==========================================================
    // Internet
    // ==========================================================

    const val INTERNET = Manifest.permission.INTERNET

    const val ACCESS_NETWORK_STATE =
        Manifest.permission.ACCESS_NETWORK_STATE

    // ==========================================================
    // Notifications
    // ==========================================================

    val POST_NOTIFICATIONS: String
        get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.POST_NOTIFICATIONS
        } else {
            ""
        }

    // ==========================================================
    // Storage
    // ==========================================================

    @Suppress("DEPRECATION")
    const val READ_EXTERNAL_STORAGE =
        Manifest.permission.READ_EXTERNAL_STORAGE

    @Suppress("DEPRECATION")
    const val WRITE_EXTERNAL_STORAGE =
        Manifest.permission.WRITE_EXTERNAL_STORAGE

    // ==========================================================
    // Media (Android 13+)
    // ==========================================================

    val READ_MEDIA_IMAGES: String
        get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_IMAGES
        } else {
            READ_EXTERNAL_STORAGE
        }

    val READ_MEDIA_VIDEO: String
        get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_VIDEO
        } else {
            READ_EXTERNAL_STORAGE
        }

    val READ_MEDIA_AUDIO: String
        get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_AUDIO
        } else {
            READ_EXTERNAL_STORAGE
        }
}
