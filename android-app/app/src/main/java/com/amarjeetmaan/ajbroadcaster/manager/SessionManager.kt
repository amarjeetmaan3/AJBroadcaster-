package com.amarjeetmaan.ajbroadcaster.manager

import android.content.SharedPreferences
import androidx.core.content.edit
import com.amarjeetmaan.ajbroadcaster.data.model.User
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Manages the current user session.
 *
 * Responsible for login state, session persistence,
 * current user information, and logout operations.
 */
@Singleton
class SessionManager @Inject constructor(
    private val preferences: SharedPreferences
) {

    companion object {
        private const val KEY_USER_ID = "session_user_id"
        private const val KEY_IS_LOGGED_IN = "session_is_logged_in"
    }

    /**
     * Returns whether a user is currently logged in.
     */
    fun isLoggedIn(): Boolean {
        return preferences.getBoolean(
            KEY_IS_LOGGED_IN,
            false
        )
    }

    /**
     * Returns the current user ID.
     */
    fun getUserId(): String? {
        return preferences.getString(
            KEY_USER_ID,
            null
        )
    }

    /**
     * Saves the current user session.
     */
    fun saveSession(
        user: User
    ) {
        preferences.edit {
            putString(
                KEY_USER_ID,
                user.id
            )
            putBoolean(
                KEY_IS_LOGGED_IN,
                true
            )
        }
    }

    /**
     * Clears the current session.
     */
    fun clearSession() {
        preferences.edit {
            remove(KEY_USER_ID)
            putBoolean(
                KEY_IS_LOGGED_IN,
                false
            )
        }
    }

    /**
     * Restores a previously saved session.
     *
     * Reserved for future implementation.
     */
    fun restoreSession() {
        // Will be implemented later.
    }
}
