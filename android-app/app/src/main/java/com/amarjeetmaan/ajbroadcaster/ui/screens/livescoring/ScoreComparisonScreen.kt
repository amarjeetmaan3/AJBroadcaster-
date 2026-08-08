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
fun ScoreComparisonScreen(
    navController: NavHostController,
    viewModel: ScoreComparisonViewModel = hiltViewModel()
) {
    val comparison by viewModel.comparison.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AJTopBar(
            title = "Score Comparison",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AJCard {
                Text(
                    text = comparison.teamA,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(text = "Score: ${comparison.teamAScore}")
                Text(text = "Overs: ${comparison.teamAOvers}")
                Text(text = "Run Rate: ${comparison.teamARunRate}")
            }

            AJCard {
                Text(
                    text = comparison.teamB,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(text = "Score: ${comparison.teamBScore}")
                Text(text = "Overs: ${comparison.teamBOvers}")
                Text(text = "Run Rate: ${comparison.teamBRunRate}")
            }
        }
    }
}
