package com.amarjeetmaan.ajbroadcaster.ui.screens.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel for SplashScreen.
 *
 * Responsible for application
 * startup initialization.
 */
@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    /**
     * Performs startup initialization.
     *
     * Firebase checks, session restore,
     * and app configuration loading
     * will be added later.
     */
    fun initialize() {
        // Reserved for future implementation.
    }
}
