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
fun PlayerStatisticsScreen(
    navController: NavHostController,
    viewModel: PlayerStatisticsViewModel = hiltViewModel()
) {
    val statistics by viewModel.statistics.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AJTopBar(
            title = "Player Statistics",
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
                    text = statistics.playerName,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(text = "Matches: ${statistics.matches}")
                Text(text = "Runs: ${statistics.runs}")
                Text(text = "Balls Faced: ${statistics.ballsFaced}")
                Text(text = "Fours: ${statistics.fours}")
                Text(text = "Sixes: ${statistics.sixes}")
                Text(text = "Strike Rate: ${statistics.strikeRate}")

                Text(text = "Wickets: ${statistics.wickets}")
                Text(text = "Overs Bowled: ${statistics.oversBowled}")
                Text(text = "Runs Conceded: ${statistics.runsConceded}")
                Text(text = "Economy: ${statistics.economy}")

                Text(text = "Catches: ${statistics.catches}")
                Text(text = "Run Outs: ${statistics.runOuts}")
                Text(text = "Stumpings: ${statistics.stumpings}")
            }
        }
    }
}
