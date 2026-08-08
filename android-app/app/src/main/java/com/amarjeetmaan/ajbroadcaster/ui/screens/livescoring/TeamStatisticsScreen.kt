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
fun TeamStatisticsScreen(
    navController: NavHostController,
    viewModel: TeamStatisticsViewModel = hiltViewModel()
) {
    val statistics by viewModel.statistics.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AJTopBar(
            title = "Team Statistics",
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
                    text = statistics.teamName,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(text = "Matches: ${statistics.matches}")
                Text(text = "Wins: ${statistics.wins}")
                Text(text = "Losses: ${statistics.losses}")
                Text(text = "Ties: ${statistics.ties}")
                Text(text = "Win Percentage: ${statistics.winPercentage}%")
                Text(text = "Total Runs: ${statistics.totalRuns}")
                Text(text = "Total Wickets: ${statistics.totalWickets}")
            }
        }
    }
}
