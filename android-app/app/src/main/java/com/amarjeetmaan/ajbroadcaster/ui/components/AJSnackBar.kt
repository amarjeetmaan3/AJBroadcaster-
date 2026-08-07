package com.amarjeetmaan.ajbroadcaster.ui.components

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Reusable Snackbar component for AJ Broadcaster.
 *
 * Supports success, error,
 * warning, and information messages.
 * Additional styling will be added
 * in future phases.
 */
@Composable
fun AJSnackBar(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {

    SnackbarHost(
        hostState = hostState,
        modifier = modifier
    ) { data: SnackbarData ->

        Snackbar {
            Text(
                text = data.visuals.message
            )
        }
    }
}
