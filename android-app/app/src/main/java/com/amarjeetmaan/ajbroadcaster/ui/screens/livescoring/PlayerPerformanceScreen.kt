package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun PlayerPerformanceScreen(
    navController: NavHostController,
    viewModel: PlayerPerformanceViewModel = hiltViewModel()
) {

    val performances by viewModel.performances.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        AJTopBar(
            title = "Player Performance",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            items(performances) { performance ->

                AJCard {

                    Text(
                        text = performance.playerName,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "Runs: ${performance.runs}"
                    )

                    Text(
                        text = "Wickets: ${performance.wickets}"
                    )

                    Text(
                        text = "Catches: ${performance.catches}"
                    )

                    Text(
                        text = "Performance Score: ${performance.performanceScore}"
                    )
                }
            }
        }
    }
}
