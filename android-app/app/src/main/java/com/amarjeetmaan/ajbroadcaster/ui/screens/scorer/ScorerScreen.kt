package com.amarjeetmaan.ajbroadcaster.ui.screens.scorer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amarjeetmaan.ajbroadcaster.ui.components.AJButton
import com.amarjeetmaan.ajbroadcaster.ui.components.AJScoreCard
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

/**
 * Ball-by-ball scorer screen.
 */
@Composable
fun ScorerScreen(
    navController: NavHostController,
    viewModel: ScorerViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        AJTopBar(
            title = "Scorer",
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
            text = "Next Ball",
            onClick = {
                viewModel.nextBall()
            }
        )
    }
}
