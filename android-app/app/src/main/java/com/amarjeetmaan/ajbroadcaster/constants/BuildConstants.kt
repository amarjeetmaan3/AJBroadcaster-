package com.amarjeetmaan.ajbroadcaster.constants

import com.amarjeetmaan.ajbroadcaster.BuildConfig

/**
 * Build-related constants.
 *
 * These values are derived from the current Gradle build.
 * Never hardcode debug/release information elsewhere.
 */
object BuildConstants {

    /**
     * True when running a Debug build.
     */
    val IS_DEBUG = BuildConfig.DEBUG

    /**
     * Current application version.
     */
    val VERSION_NAME = BuildConfig.VERSION_NAME

    /**
     * Current version code.
     */
    val VERSION_CODE = BuildConfig.VERSION_CODE

    /**
     * Application ID defined in Gradle.
     */
    const val APPLICATION_ID = "com.amarjeetmaan.ajbroadcaster"

    /**
     * Minimum Android SDK supported.
     */
    const val MIN_SDK = 26

    /**
     * Target Android SDK.
     */
    const val TARGET_SDK = 34

    /**
     * Compile SDK.
     */
    const val COMPILE_SDK = 34
}
