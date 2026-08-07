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
import com.amarjeetmaan.ajbroadcaster.ui.components.AJButton
import com.amarjeetmaan.ajbroadcaster.ui.components.AJMatchCard
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

/**
 * Displays complete information
 * about a selected match.
 */
@Composable
fun MatchDetailsScreen(
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        AJTopBar(
            title = "Match Details",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        AJMatchCard(
            teamA = "CSK",
            teamB = "RCB",
            matchStatus = "Upcoming",
            venue = "Amargarh"
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Match information, squads, officials, toss, and live statistics will appear here.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        AJButton(
            text = "Start Scoring",
            onClick = {
                // Navigation will be connected later.
            }
        )
    }
}
