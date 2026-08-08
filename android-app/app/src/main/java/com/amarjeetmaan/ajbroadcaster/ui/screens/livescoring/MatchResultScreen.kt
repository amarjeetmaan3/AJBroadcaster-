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
fun MatchResultScreen(
    navController: NavHostController,
    viewModel: MatchResultViewModel = hiltViewModel()
) {
    val result by viewModel.result.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AJTopBar(
            title = "Match Result",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        AJCard {
            Text(
                text = result.result,
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                text = "${result.winner} won the match."
            )

            Text(
                text = "Margin: ${result.margin}"
            )

            Text(
                text = "Player of the Match: ${result.playerOfMatch}"
            )
        }
    }
}
