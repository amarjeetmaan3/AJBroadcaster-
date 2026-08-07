package com.amarjeetmaan.ajbroadcaster.manager

import android.app.NotificationChannel
import android.app.NotificationManager as AndroidNotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Centralized notification manager.
 *
 * Handles application notifications including
 * live streaming, match updates, and reminders.
 */
@Singleton
class NotificationManager @Inject constructor(
    @ApplicationContext
    private val context: Context
) {

    companion object {
        const val CHANNEL_ID = "aj_broadcaster_channel"
        const val CHANNEL_NAME = "AJ Broadcaster"
        const val CHANNEL_DESCRIPTION =
            "Broadcast and match notifications"
    }

    /**
     * Creates the notification channel.
     */
    fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                AndroidNotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = CHANNEL_DESCRIPTION
            }

            val manager =
                context.getSystemService(
                    AndroidNotificationManager::class.java
                )

            manager?.createNotificationChannel(channel)
        }
    }

    /**
     * Displays a simple notification.
     */
    fun showNotification(
        notificationId: Int,
        title: String,
        message: String
    ) {

        val notification = NotificationCompat.Builder(
            context,
            CHANNEL_ID
        )
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(context)
            .notify(
                notificationId,
                notification
            )
    }

    /**
     * Cancels a notification.
     */
    fun cancelNotification(
        notificationId: Int
    ) {
        NotificationManagerCompat.from(context)
            .cancel(notificationId)
    }

    /**
     * Cancels all notifications.
     */
    fun cancelAllNotifications() {
        NotificationManagerCompat.from(context)
            .cancelAll()
    }
}
