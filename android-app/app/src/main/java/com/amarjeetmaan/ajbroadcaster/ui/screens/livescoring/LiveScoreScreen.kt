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
fun LiveScoreScreen(
    navController: NavHostController,
    viewModel: LiveScoreViewModel = hiltViewModel()
) {
    val score by viewModel.score.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AJTopBar(
            title = "Live Score",
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
                    text = score.battingTeam,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = "${score.runs}/${score.wickets}",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(text = "Overs: ${score.overs}")
                Text(text = "Run Rate: ${score.runRate}")
                Text(text = "Target: ${score.target}")
                Text(text = "Required: ${score.requiredRuns}")
            }
        }
    }
}
