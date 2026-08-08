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
fun ScoreSummaryScreen(
    navController: NavHostController,
    viewModel: ScoreSummaryViewModel = hiltViewModel()
) {
    val summary by viewModel.summary.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AJTopBar(
            title = "Score Summary",
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
                    text = summary.teamName,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = "${summary.runs}/${summary.wickets}",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(text = "Overs: ${summary.overs}")
                Text(text = "Run Rate: ${summary.runRate}")
                Text(text = "Target: ${summary.target}")
                Text(text = "Required: ${summary.requiredRuns}")
            }
        }
    }
}
