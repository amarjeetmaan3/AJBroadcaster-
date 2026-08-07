package com.amarjeetmaan.ajbroadcaster.service

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.amarjeetmaan.ajbroadcaster.manager.NotificationManager
import com.amarjeetmaan.ajbroadcaster.manager.StreamManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Foreground service responsible for
 * maintaining live streaming while the
 * application is in the background.
 *
 * Streaming implementation will be
 * added in future phases.
 */
@AndroidEntryPoint
class StreamingService : Service() {

    @Inject
    lateinit var streamManager: StreamManager

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

        startForeground(
            NOTIFICATION_ID,
            createNotification()
        )

        return START_STICKY
    }

    override fun onDestroy() {
        streamManager.release()
        super.onDestroy()
    }

    override fun onBind(
        intent: Intent?
    ): IBinder? {
        return null
    }

    /**
     * Creates the foreground notification.
     */
    private fun createNotification(): Notification {

        return NotificationCompat.Builder(
            this,
            NotificationManager.CHANNEL_ID
        )
            .setSmallIcon(
                android.R.drawable.presence_video_online
            )
            .setContentTitle(
                "AJ Broadcaster"
            )
            .setContentText(
                "Live streaming is running."
            )
            .setOngoing(true)
            .build()
    }

    companion object {
        private const val NOTIFICATION_ID = 1001
    }
}
