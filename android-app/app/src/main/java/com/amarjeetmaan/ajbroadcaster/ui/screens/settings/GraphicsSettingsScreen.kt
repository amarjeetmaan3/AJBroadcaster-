package com.amarjeetmaan.ajbroadcaster.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Graphics settings screen.
 *
 * Controls preferences related to
 * broadcast graphics and overlays.
 */
@Composable
fun GraphicsSettingsScreen() {

    var graphicsEnabled by remember {
        mutableStateOf(true)
    }

    var animationsEnabled by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Graphics Settings",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Enable Broadcast Graphics"
        )

        Switch(
            checked = graphicsEnabled,
            onCheckedChange = {
                graphicsEnabled = it
            }
        )

        Text(
            text = "Enable Graphic Animations"
        )

        Switch(
            checked = animationsEnabled,
            onCheckedChange = {
                animationsEnabled = it
            }
        )
    }
}
