package com.amarjeetmaan.ajbroadcaster.ui.screens.scoreboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amarjeetmaan.ajbroadcaster.ui.components.AJScoreCard
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

/**
 * Displays the live scoreboard.
 */
@Composable
fun ScoreboardScreen(
    navController: NavHostController,
    viewModel: ScoreboardViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        AJTopBar(
            title = "Scoreboard",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        AJScoreCard(
            teamName = "CSK",
            score = "125/4",
            overs = "15.3",
            runRate = "8.06"
        )
    }
}
