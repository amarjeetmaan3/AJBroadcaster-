package com.amarjeetmaan.ajbroadcaster.ui.screens.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amarjeetmaan.ajbroadcaster.ui.components.AJButton
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar
import com.amarjeetmaan.ajbroadcaster.ui.navigation.NavigationDestination

/**
 * Dashboard screen for AJ Broadcaster.
 *
 * Displays the main entry points
 * of the application.
 */
@Composable
fun DashboardScreen(
    navController: NavHostController,
    viewModel: DashboardViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        AJTopBar(
            title = "Dashboard"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Welcome to AJ Broadcaster",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        AJButton(
            text = "Live Scoring",
            onClick = {
                navController.navigate(
                    NavigationDestination.LiveScoring.route
                )
            }
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        AJButton(
            text = "Streaming",
            onClick = {
                navController.navigate(
                    NavigationDestination.Streaming.route
                )
            }
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        AJButton(
            text = "Settings",
            onClick = {
                navController.navigate(
                    NavigationDestination.Settings.route
                )
            }
        )
    }
}
