package com.amarjeetmaan.ajbroadcaster.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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

/**
 * Theme settings screen.
 *
 * Controls application appearance.
 */
@Composable
fun ThemeSettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel()
) {

    val darkMode by viewModel.darkMode.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Theme",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Enable Dark Mode"
        )

        Switch(
            checked = darkMode,
            onCheckedChange = {
                viewModel.setDarkMode(it)
            }
        )
    }
}
