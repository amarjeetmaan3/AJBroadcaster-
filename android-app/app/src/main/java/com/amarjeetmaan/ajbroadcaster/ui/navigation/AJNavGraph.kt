package com.amarjeetmaan.ajbroadcaster.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amarjeetmaan.ajbroadcaster.ui.screens.about.AboutScreen
import com.amarjeetmaan.ajbroadcaster.ui.screens.dashboard.DashboardScreen
import com.amarjeetmaan.ajbroadcaster.ui.screens.login.LoginScreen
import com.amarjeetmaan.ajbroadcaster.ui.screens.profile.ProfileScreen
import com.amarjeetmaan.ajbroadcaster.ui.screens.settings.SettingsScreen
import com.amarjeetmaan.ajbroadcaster.ui.screens.splash.SplashScreen

/**
 * Main navigation graph for
 * AJ Broadcaster.
 *
 * Additional screens will be
 * connected as they are created.
 */
@Composable
fun AJNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationDestination.Splash.route
    ) {

        composable(
            NavigationDestination.Splash.route
        ) {
            SplashScreen(navController)
        }

        composable(
            NavigationDestination.Login.route
        ) {
            LoginScreen(navController)
        }

        composable(
            NavigationDestination.Dashboard.route
        ) {
            DashboardScreen(navController)
        }

        composable(
            NavigationDestination.Profile.route
        ) {
            ProfileScreen(navController)
        }

        composable(
            NavigationDestination.Settings.route
        ) {
            SettingsScreen(navController)
        }

        composable(
            NavigationDestination.About.route
        ) {
            AboutScreen(navController)
        }
    }
}
