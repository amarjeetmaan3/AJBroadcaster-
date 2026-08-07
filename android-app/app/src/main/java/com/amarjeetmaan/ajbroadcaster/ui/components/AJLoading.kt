package com.amarjeetmaan.ajbroadcaster.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * Reusable loading component for AJ Broadcaster.
 *
 * Supports fullscreen and inline loading.
 */
@Composable
fun AJLoading(
    modifier: Modifier = Modifier,
    message: String = "Loading...",
    fullScreen: Boolean = true
) {

    if (fullScreen) {

        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                CircularProgressIndicator()

                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

    } else {

        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CircularProgressIndicator()

            Text(
                text = message,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
