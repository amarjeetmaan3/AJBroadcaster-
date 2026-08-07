package com.amarjeetmaan.ajbroadcaster.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import dagger.hilt.android.AndroidEntryPoint

/**
 * Handles background uploads for
 * recordings, highlight videos,
 * graphics assets, sponsor media,
 * and other large files.
 *
 * Upload implementation will be
 * added in future phases.
 */
@AndroidEntryPoint
class UploadService : Service() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int
    ): Int {

        startUpload()

        return START_STICKY
    }

    override fun onDestroy() {
        stopUpload()
        super.onDestroy()
    }

    override fun onBind(
        intent: Intent?
    ): IBinder? {
        return null
    }

    /**
     * Starts upload processing.
     */
    private fun startUpload() {
        // Upload logic will be
        // implemented later.
    }

    /**
     * Stops upload processing.
     */
    private fun stopUpload() {
        // Reserved for future implementation.
    }
}
