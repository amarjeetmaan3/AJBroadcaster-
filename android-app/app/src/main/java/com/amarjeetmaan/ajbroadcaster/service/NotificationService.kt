package com.amarjeetmaan.ajbroadcaster.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.amarjeetmaan.ajbroadcaster.manager.NotificationManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Background service responsible for
 * processing scheduled and real-time
 * application notifications.
 *
 * Notification scheduling and delivery
 * will be implemented in future phases.
 */
@AndroidEntryPoint
class NotificationService : Service() {

    @Inject
    lateinit var notificationManager: NotificationManager

    override fun onCreate() {
        super.onCreate()

        notificationManager.createNotificationChannel()
    }

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int
    ): Int {

        processNotifications()

        return START_STICKY
    }

    override fun onDestroy() {
        stopProcessing()
        super.onDestroy()
    }

    override fun onBind(
        intent: Intent?
    ): IBinder? {
        return null
    }

    /**
     * Starts notification processing.
     */
    private fun processNotifications() {
        // Scheduled notification logic
        // will be implemented later.
    }

    /**
     * Stops notification processing.
     */
    private fun stopProcessing() {
        // Reserved for future implementation.
    }
}
