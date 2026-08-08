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
fun CurrentBatsmenScreen(
    navController: NavHostController,
    viewModel: CurrentBatsmenViewModel = hiltViewModel()
) {

    val batsmen by viewModel.batsmen.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        AJTopBar(
            title = "Current Batsmen",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        batsmen.forEach { batsman ->

            AJCard {

                Text(
                    text = batsman.name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "${batsman.runs} runs (${batsman.balls})"
                )

                Text(
                    text = "4s: ${batsman.fours}   6s: ${batsman.sixes}"
                )

                Text(
                    text = "SR: ${batsman.strikeRate}"
                )

                if (batsman.isStriker) {
                    Text(
                        text = "STRIKER",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}
