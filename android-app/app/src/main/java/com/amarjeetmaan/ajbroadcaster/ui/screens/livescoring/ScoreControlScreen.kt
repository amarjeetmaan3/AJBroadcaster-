package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
fun ScoreControlScreen(
    navController: NavHostController,
    viewModel: ScoreControlViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AJTopBar(
            title = "Score Control",
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
                    text = state.teamName,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = "${state.runs}/${state.wickets}",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(text = "Overs: ${state.overs}")
                Text(text = "Last ball: ${state.lastBall}")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { viewModel.addRuns(1) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("1")
                }

                Button(
                    onClick = { viewModel.addRuns(2) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("2")
                }

                Button(
                    onClick = { viewModel.addRuns(4) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("4")
                }

                Button(
                    onClick = { viewModel.addRuns(6) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("6")
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { viewModel.addExtra() },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Wide")
                }

                Button(
                    onClick = { viewModel.addWicket() },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Wicket")
                }

                Button(
                    onClick = { viewModel.addDotBall() },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Dot")
                }
            }
        }
    }
}
