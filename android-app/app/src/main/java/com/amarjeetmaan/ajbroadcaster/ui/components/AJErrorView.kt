package com.amarjeetmaan.ajbroadcaster.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Reusable error view component.
 *
 * Displays an error message
 * with an optional retry action.
 */
@Composable
fun AJErrorView(
    title: String,
    message: String,
    modifier: Modifier = Modifier,
    retryText: String = "Retry",
    onRetry: (() -> Unit)? = null
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = Icons.Default.Error,
            contentDescription = null
        )

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium
        )

        onRetry?.let {

            Button(
                onClick = it
            ) {
                Text(retryText)
            }
        }
    }
}
