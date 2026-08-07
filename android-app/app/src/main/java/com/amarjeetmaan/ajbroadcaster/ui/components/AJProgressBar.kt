package com.amarjeetmaan.ajbroadcaster.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Reusable progress bar component.
 *
 * Supports determinate and
 * indeterminate progress.
 */
@Composable
fun AJProgressBar(
    modifier: Modifier = Modifier,
    progress: Float? = null,
    label: String? = null
) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        label?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        if (progress == null) {

            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth()
            )

        } else {

            LinearProgressIndicator(
                progress = { progress.coerceIn(0f, 1f) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
