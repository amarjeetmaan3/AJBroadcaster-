package com.amarjeetmaan.ajbroadcaster.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Reusable player card component.
 *
 * Displays player information and
 * basic match statistics.
 * More player details and actions
 * will be added in future phases.
 */
@Composable
fun AJPlayerCard(
    playerName: String,
    role: String,
    stats: String,
    modifier: Modifier = Modifier
) {

    AJCard(modifier = modifier) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {

                Text(
                    text = playerName,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = role,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Text(
                text = stats,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
