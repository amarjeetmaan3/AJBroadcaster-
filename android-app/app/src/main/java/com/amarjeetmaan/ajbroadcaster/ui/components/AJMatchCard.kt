package com.amarjeetmaan.ajbroadcaster.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding

/**
 * Reusable match card component.
 *
 * Displays basic match information.
 * Additional live status, venue,
 * officials, and actions will be
 * added in future phases.
 */
@Composable
fun AJMatchCard(
    teamA: String,
    teamB: String,
    matchStatus: String,
    venue: String,
    modifier: Modifier = Modifier
) {

    AJCard(modifier = modifier) {

        Text(
            text = "$teamA vs $teamB",
            style = MaterialTheme.typography.titleLarge
        )

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {

                Text(
                    text = "Status",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = matchStatus,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Column {

                Text(
                    text = "Venue",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = venue,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
