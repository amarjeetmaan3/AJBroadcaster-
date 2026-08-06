package com.amarjeetmaan.ajbroadcaster.constants

import com.amarjeetmaan.ajbroadcaster.navigation.AppRoutes

/**
 * Navigation configuration constants.
 *
 * NOTE:
 * Route names belong in AppRoutes.kt.
 * This file only stores navigation configuration values.
 */
object NavigationConstants {

    /**
     * First screen opened when the application launches.
     */
    const val DEFAULT_START_DESTINATION = AppRoutes.HOME

    /**
     * Prevents unlimited back stack growth.
     */
    const val MAX_BACK_STACK_SIZE = 10

    /**
     * Default animation duration (milliseconds).
     */
    const val DEFAULT_NAV_ANIMATION_DURATION = 300L

    /**
     * Delay before executing navigation to prevent double clicks.
     */
    const val NAVIGATION_DELAY_MS = 150L

    /**
     * Enable navigation logging in debug builds.
     */
    const val ENABLE_NAVIGATION_LOGS = true

    /**
     * Navigation transition names.
     */
    const val TRANSITION_FADE = "fade"

    const val TRANSITION_SLIDE = "slide"

    const val TRANSITION_NONE = "none"
}
