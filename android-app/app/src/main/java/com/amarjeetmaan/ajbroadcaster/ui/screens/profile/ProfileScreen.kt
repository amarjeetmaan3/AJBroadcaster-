package com.amarjeetmaan.ajbroadcaster.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amarjeetmaan.ajbroadcaster.ui.components.AJButton
import com.amarjeetmaan.ajbroadcaster.ui.components.AJCard
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

/**
 * Profile screen for AJ Broadcaster.
 *
 * Displays user profile information.
 * Profile editing and account management
 * will be implemented later.
 */
@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        AJTopBar(
            title = "Profile",
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
                text = "Name",
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                text = "AJ Broadcaster User",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(
                text = "Email",
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                text = "user@example.com",
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        AJButton(
            text = "Edit Profile",
            onClick = {
                // Reserved for future implementation.
            }
        )
    }
}
