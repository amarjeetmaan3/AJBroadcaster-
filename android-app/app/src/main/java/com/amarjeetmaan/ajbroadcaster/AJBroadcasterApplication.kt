package com.amarjeetmaan.ajbroadcaster

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application entry point for AJ Broadcaster.
 *
 * Initializes Hilt dependency injection and
 * provides application-level configuration.
 */
@HiltAndroidApp
class AJBroadcasterApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeApplication()
    }

    /**
     * Initializes application components.
     *
     * Additional startup logic such as analytics,
     * logging, crash reporting, and feature
     * initialization can be added here.
     */
    private fun initializeApplication() {
        // Reserved for future initialization.
    }
}
