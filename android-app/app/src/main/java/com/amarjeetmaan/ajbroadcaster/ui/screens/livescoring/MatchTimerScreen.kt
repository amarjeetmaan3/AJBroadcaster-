package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

@Composable
fun MatchTimerScreen(
    navController: NavHostController,
    viewModel: MatchTimerViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AJTopBar(
            title = "Match Timer",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = state.displayTime
            )

            Text(
                text = if (state.isRunning) {
                    "RUNNING"
                } else {
                    "PAUSED"
                }
            )

            Button(
                onClick = viewModel::toggle
            ) {
                Text(
                    if (state.isRunning) {
                        "Pause"
                    } else {
                        "Start"
                    }
                )
            }

            Button(
                onClick = viewModel::reset
            ) {
                Text("Reset")
            }
        }
    }
}
