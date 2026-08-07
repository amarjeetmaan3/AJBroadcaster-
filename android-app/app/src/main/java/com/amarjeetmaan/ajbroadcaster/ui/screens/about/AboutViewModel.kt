package com.amarjeetmaan.ajbroadcaster.ui.screens.about

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel for AboutScreen.
 *
 * Responsible for loading
 * application metadata such as
 * version, build information,
 * and license details.
 */
@HiltViewModel
class AboutViewModel @Inject constructor() : ViewModel() {

    /**
     * Loads application information.
     *
     * Dynamic version and build
     * information will be added
     * in future phases.
     */
    fun loadAppInfo() {
        // Reserved for future implementation.
    }
}
