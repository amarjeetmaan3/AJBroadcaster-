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
fun TargetScreen(
    navController: NavHostController,
    viewModel: TargetViewModel = hiltViewModel()
) {
    val target by viewModel.target.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AJTopBar(
            title = "Target",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        AJCard {
            Text(
                text = "Chase Information",
                style = MaterialTheme.typography.titleLarge
            )

            Text(text = "Target: ${target.target}")
            Text(text = "Current Score: ${target.currentScore}")
            Text(text = "Runs Required: ${target.runsRequired}")
            Text(text = "Balls Remaining: ${target.ballsRemaining}")
            Text(text = "Required Run Rate: ${target.requiredRunRate}")
        }
    }
}
