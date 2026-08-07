package com.amarjeetmaan.ajbroadcaster.ui.screens.about

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
import com.amarjeetmaan.ajbroadcaster.ui.components.AJCard
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

/**
 * About screen for AJ Broadcaster.
 *
 * Displays application information,
 * version details, and developer
 * information.
 */
@Composable
fun AboutScreen(
    navController: NavHostController,
    viewModel: AboutViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        AJTopBar(
            title = "About",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        AJCard {

            Text(
                text = "AJ Broadcaster",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Version 1.0.0",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = "Professional cricket broadcasting platform for live scoring, streaming, graphics, and tournament management.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
