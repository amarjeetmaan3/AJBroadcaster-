package com.amarjeetmaan.ajbroadcaster.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Score settings screen.
 *
 * Controls preferences related to
 * live scoring and score updates.
 */
@Composable
fun ScoreSettingsScreen() {

    var autoSave by remember {
        mutableStateOf(true)
    }

    var liveSync by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Score Settings",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Automatically Save Score"
        )

        Switch(
            checked = autoSave,
            onCheckedChange = {
                autoSave = it
            }
        )

        Text(
            text = "Live Score Synchronization"
        )

        Switch(
            checked = liveSync,
            onCheckedChange = {
                liveSync = it
            }
        )
    }
}
