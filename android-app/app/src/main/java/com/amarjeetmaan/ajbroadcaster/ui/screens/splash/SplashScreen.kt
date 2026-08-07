package com.amarjeetmaan.ajbroadcaster.ui.screens.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amarjeetmaan.ajbroadcaster.ui.navigation.NavigationDestination
import kotlinx.coroutines.delay

/**
 * Splash screen for AJ Broadcaster.
 *
 * Displays the application logo while
 * performing initial startup tasks.
 */
@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: SplashViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {

        delay(1500)

        navController.navigate(
            NavigationDestination.Login.route
        ) {
            popUpTo(
                NavigationDestination.Splash.route
            ) {
                inclusive = true
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "AJ Broadcaster",
            style = MaterialTheme.typography.headlineMedium
        )

        CircularProgressIndicator()

        Text(
            text = "Loading...",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
