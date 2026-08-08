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
fun CurrentBowlerScreen(
    navController: NavHostController,
    viewModel: CurrentBowlerViewModel = hiltViewModel()
) {

    val bowler by viewModel.bowler.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        AJTopBar(
            title = "Current Bowler",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        AJCard {

            Text(
                text = bowler.name,
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "Overs: ${bowler.overs}"
            )

            Text(
                text = "Runs: ${bowler.runs}"
            )

            Text(
                text = "Wickets: ${bowler.wickets}"
            )

            Text(
                text = "Economy: ${bowler.economy}"
            )

            Text(
                text = "Dots: ${bowler.dots}"
            )
        }
    }
}
