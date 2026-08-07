package com.amarjeetmaan.ajbroadcaster.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Reusable button component for AJ Broadcaster.
 *
 * Supports normal and loading states.
 * Additional styles (secondary, destructive,
 * icon button, etc.) will be added later.
 */
@Composable
fun AJButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        enabled = enabled && !loading,
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp),
        shape = MaterialTheme.shapes.medium,
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 12.dp
        ),
        colors = ButtonDefaults.buttonColors()
    ) {

        if (loading) {

            CircularProgressIndicator(
                strokeWidth = 2.dp
            )

        } else {

            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}
