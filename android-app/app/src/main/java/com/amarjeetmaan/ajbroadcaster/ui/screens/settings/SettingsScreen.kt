package com.amarjeetmaan.ajbroadcaster.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
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

/**
 * Settings screen for AJ Broadcaster.
 *
 * Displays application settings.
 * Additional settings will be
 * added in future phases.
 */
@Composable
fun SettingsScreen(
    navController: NavHostController,
    viewModel: SettingsViewModel = hiltViewModel()
) {

    val darkMode by viewModel.darkMode.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        AJTopBar(
            title = "Settings",
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
                text = "Appearance",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            androidx.compose.foundation.layout.Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {

                Text(
                    text = "Dark Mode"
                )

                Switch(
                    checked = darkMode,
                    onCheckedChange = {
                        viewModel.setDarkMode(it)
                    }
                )
            }
        }
    }
}
