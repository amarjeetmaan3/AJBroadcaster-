package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amarjeetmaan.ajbroadcaster.ui.components.AJCard
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

@Composable
fun MatchDetailsScreen(
    navController: NavHostController,
    viewModel: MatchDetailsViewModel = hiltViewModel()
) {
    val details by viewModel.details.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AJTopBar(
            title = "Match Details",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AJCard {
                Text(
                    text = details.leagueName,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(text = "Match: ${details.matchNumber}")
                Text(text = "Type: ${details.matchType}")
                Text(text = "Team A: ${details.teamA}")
                Text(text = "Team B: ${details.teamB}")
                Text(text = "Venue: ${details.venue}")
                Text(text = "Date: ${details.date}")
                Text(text = "Time: ${details.time}")
                Text(text = "Overs: ${details.overs}")
            }
        }
    }
}
