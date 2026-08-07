package com.amarjeetmaan.ajbroadcaster.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for LoginScreen.
 *
 * Handles user authentication.
 * Firebase Authentication will
 * be integrated in future phases.
 */
@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    /**
     * Attempts to log in.
     *
     * Real authentication will
     * be implemented later.
     */
    fun login(
        email: String,
        password: String
    ) {

        viewModelScope.launch {

            // Firebase Authentication
            // will be added later.
        }
    }
}
