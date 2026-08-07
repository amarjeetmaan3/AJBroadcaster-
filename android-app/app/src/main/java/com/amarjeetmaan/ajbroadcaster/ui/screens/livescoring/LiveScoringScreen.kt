package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

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
import com.amarjeetmaan.ajbroadcaster.ui.components.AJButton
import com.amarjeetmaan.ajbroadcaster.ui.components.AJScoreCard
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

/**
 * Main live scoring screen.
 *
 * Ball-by-ball controls and
 * score graphics will be
 * connected in future phases.
 */
@Composable
fun LiveScoringScreen(
    navController: NavHostController,
    viewModel: LiveScoringViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        AJTopBar(
            title = "Live Scoring",
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
            score = "0/0",
            overs = "0.0",
            runRate = "0.00"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        AJButton(
            text = "Start Innings",
            onClick = {
                viewModel.startInnings()
            }
        )
    }
}
