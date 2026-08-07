package com.amarjeetmaan.ajbroadcaster.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Account settings screen.
 *
 * Displays account-related options.
 */
@Composable
fun AccountSettingsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Account",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Profile"
        )

        Text(
            text = "Change Password"
        )

        Text(
            text = "Logout"
        )
    }
}
