package com.amarjeetmaan.ajbroadcaster.ui.screens.matchdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.amarjeetmaan.ajbroadcaster.ui.components.AJCard
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

/**
 * Displays a summary of a completed
 * or currently active match.
 */
@Composable
fun MatchSummaryScreen(
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        AJTopBar(
            title = "Match Summary",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        AJCard {

            Text(
                text = "CSK vs RCB",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "CSK 125/4 (15.3)",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "RCB 120/8 (15.0)",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "CSK won by 5 runs.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
