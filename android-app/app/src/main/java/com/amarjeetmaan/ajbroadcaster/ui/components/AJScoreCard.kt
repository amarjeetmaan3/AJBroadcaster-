package com.amarjeetmaan.ajbroadcaster.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Basic reusable cricket score card.
 *
 * Advanced TV graphics and animations
 * will be implemented later.
 */
@Composable
fun AJScoreCard(
    teamName: String,
    score: String,
    overs: String,
    runRate: String,
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
                    text = "Score",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = score,
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            Column {

                Text(
                    text = "Overs",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = overs,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Column {

                Text(
                    text = "RR",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = runRate,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
