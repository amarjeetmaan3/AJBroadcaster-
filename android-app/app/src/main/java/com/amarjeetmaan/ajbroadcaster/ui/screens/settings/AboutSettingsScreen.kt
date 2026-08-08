package com.amarjeetmaan.ajbroadcaster.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * About settings screen.
 *
 * Displays application version,
 * build information, and basic
 * application details.
 */
@Composable
fun AboutSettingsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "About AJ Broadcaster",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Version 1.0.0",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "AJ Broadcaster is a cricket broadcasting platform designed for live scoring, streaming, graphics, and tournament management.",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Built for professional cricket coverage.",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
