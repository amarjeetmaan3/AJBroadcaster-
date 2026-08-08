package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
fun UndoScoreScreen(
    navController: NavHostController,
    viewModel: UndoScoreViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AJTopBar(
            title = "Undo Score",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AJCard {
                Text(
                    text = "Current Score",
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = "${state.runs}/${state.wickets}"
                )

                Text(
                    text = "Overs: ${state.overs}"
                )

                Text(
                    text = "Last Event: ${state.lastEvent}"
                )
            }

            Button(
                onClick = viewModel::undoLastEvent,
                enabled = state.canUndo
            ) {
                Text("UNDO LAST EVENT")
            }

            Button(
                onClick = viewModel::clearHistory,
                enabled = state.historySize > 0
            ) {
                Text("CLEAR HISTORY")
            }
        }
    }
}
