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
fun MatchStatisticsScreen(
    navController: NavHostController,
    viewModel: MatchStatisticsViewModel = hiltViewModel()
) {
    val statistics by viewModel.statistics.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AJTopBar(
            title = "Match Statistics",
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
                    text = "Match Statistics",
                    style = MaterialTheme.typography.titleLarge
                )

                Text(text = "Total Runs: ${statistics.totalRuns}")
                Text(text = "Total Wickets: ${statistics.totalWickets}")
                Text(text = "Total Fours: ${statistics.totalFours}")
                Text(text = "Total Sixes: ${statistics.totalSixes}")
                Text(text = "Total Extras: ${statistics.totalExtras}")
                Text(text = "Run Rate: ${statistics.runRate}")
                Text(text = "Highest Partnership: ${statistics.highestPartnership}")
            }
        }
    }
}
