package com.amarjeetmaan.ajbroadcaster.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.amarjeetmaan.ajbroadcaster.manager.ScoreManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Synchronizes live cricket scoring
 * with Firebase Realtime Database.
 *
 * Real-time synchronization logic
 * will be added in future phases.
 */
@AndroidEntryPoint
class ScoreSyncService : Service() {

    @Inject
    lateinit var scoreManager: ScoreManager

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int
    ): Int {

        startSynchronization()

        return START_STICKY
    }

    override fun onDestroy() {
        stopSynchronization()
        super.onDestroy()
    }

    override fun onBind(
        intent: Intent?
    ): IBinder? {
        return null
    }

    /**
     * Starts score synchronization.
     */
    private fun startSynchronization() {
        // Firebase synchronization
        // will be implemented later.
    }

    /**
     * Stops score synchronization.
     */
    private fun stopSynchronization() {
        // Reserved.
    }
}
