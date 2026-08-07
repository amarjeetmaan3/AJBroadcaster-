package com.amarjeetmaan.ajbroadcaster.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Notification settings screen.
 *
 * Controls app notification preferences.
 */
@Composable
fun NotificationSettingsScreen() {

    var notificationsEnabled by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Notifications",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Enable Notifications"
        )

        Switch(
            checked = notificationsEnabled,
            onCheckedChange = {
                notificationsEnabled = it
            }
        )
    }
}
