package com.amarjeetmaan.ajbroadcaster.ui.screens.settings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * ViewModel for SettingsScreen.
 *
 * Manages application settings.
 */
@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {

    private val _darkMode =
        MutableStateFlow(false)

    /**
     * Emits current dark mode state.
     */
    val darkMode: StateFlow<Boolean>
        get() = _darkMode

    /**
     * Updates dark mode state.
     *
     * Theme persistence will be
     * implemented in future phases.
     */
    fun setDarkMode(
        enabled: Boolean
    ) {
        _darkMode.value = enabled
    }
}
