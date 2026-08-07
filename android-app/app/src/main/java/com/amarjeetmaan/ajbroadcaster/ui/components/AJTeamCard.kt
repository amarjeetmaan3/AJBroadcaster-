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
 * Reusable team card component.
 *
 * Displays team information,
 * captain, players count,
 * and basic team statistics.
 */
@Composable
fun AJTeamCard(
    teamName: String,
    captain: String,
    playerCount: Int,
    modifier: Modifier = Modifier
) {

    AJCard(modifier = modifier) {

        Text(
            text = teamName,
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
                    text = "Captain",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = captain,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Column {

                Text(
                    text = "Players",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = playerCount.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
