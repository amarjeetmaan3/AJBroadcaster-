package com.amarjeetmaan.ajbroadcaster.ui.screens.streaming

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
import com.amarjeetmaan.ajbroadcaster.ui.components.AJButton
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

/**
 * Streaming screen.
 *
 * Controls live streaming,
 * recording, bitrate, and
 * stream status.
 */
@Composable
fun StreamingScreen(
    navController: NavHostController,
    viewModel: StreamingViewModel = hiltViewModel()
) {

    val streaming by viewModel.isStreaming.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        AJTopBar(
            title = "Streaming",
            showBackButton = true,
            onBackClick = { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (streaming) "LIVE" else "OFFLINE",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        Switch(
            checked = streaming,
            onCheckedChange = {
                viewModel.setStreaming(it)
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        AJButton(
            text = if (streaming) "Stop Stream" else "Start Stream",
            onClick = {
                viewModel.toggleStreaming()
            }
        )
    }
}
