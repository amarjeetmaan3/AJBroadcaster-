package com.amarjeetmaan.ajbroadcaster.manager

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Centralized runtime permission manager.
 *
 * Handles permission checking for all
 * Android permissions required by AJ Broadcaster.
 */
@Singleton
class PermissionManager @Inject constructor(
    @ApplicationContext
    private val context: Context
) {

    /**
     * Returns true if Camera permission is granted.
     */
    fun hasCameraPermission(): Boolean {
        return hasPermission(
            Manifest.permission.CAMERA
        )
    }

    /**
     * Returns true if Microphone permission is granted.
     */
    fun hasMicrophonePermission(): Boolean {
        return hasPermission(
            Manifest.permission.RECORD_AUDIO
        )
    }

    /**
     * Returns true if Notification permission is granted.
     */
    fun hasNotificationPermission(): Boolean {
        return hasPermission(
            Manifest.permission.POST_NOTIFICATIONS
        )
    }

    /**
     * Returns true if Read Storage permission is granted.
     */
    fun hasReadStoragePermission(): Boolean {
        return hasPermission(
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }

    /**
     * Returns true if Write Storage permission is granted.
     */
    fun hasWriteStoragePermission(): Boolean {
        return hasPermission(
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }

    /**
     * Returns whether a permission is granted.
     */
    fun hasPermission(
        permission: String
    ): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }
}
