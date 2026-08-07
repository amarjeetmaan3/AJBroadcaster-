package com.amarjeetmaan.ajbroadcaster.ui.navigation

/**
 * Defines all navigation destinations
 * used throughout AJ Broadcaster.
 *
 * New destinations should be added here
 * as the application grows.
 */
sealed class NavigationDestination(
    val route: String
) {

    object Splash : NavigationDestination(
        "splash"
    )

    object Login : NavigationDestination(
        "login"
    )

    object Dashboard : NavigationDestination(
        "dashboard"
    )

    object MatchList : NavigationDestination(
        "match_list"
    )

    object MatchDetails : NavigationDestination(
        "match_details"
    )

    object LiveScoring : NavigationDestination(
        "live_scoring"
    )

    object Streaming : NavigationDestination(
        "streaming"
    )

    object Graphics : NavigationDestination(
        "graphics"
    )

    object Tournament : NavigationDestination(
        "tournament"
    )

    object Players : NavigationDestination(
        "players"
    )

    object Teams : NavigationDestination(
        "teams"
    )

    object Settings : NavigationDestination(
        "settings"
    )

    object Profile : NavigationDestination(
        "profile"
    )

    object About : NavigationDestination(
        "about"
    )
}
