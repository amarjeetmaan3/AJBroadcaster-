package com.amarjeetmaan.ajbroadcaster.manager

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Manages application theme settings.
 *
 * Responsible for applying, persisting,
 * and observing theme changes.
 */
@Singleton
class ThemeManager @Inject constructor(
    private val preferences: SharedPreferences
) {

    companion object {
        private const val KEY_THEME = "app_theme"

        const val THEME_SYSTEM = "System"
        const val THEME_LIGHT = "Light"
        const val THEME_DARK = "Dark"
    }

    private val _currentTheme =
        MutableStateFlow(loadTheme())

    /**
     * Emits the currently selected theme.
     */
    val currentTheme: StateFlow<String>
        get() = _currentTheme

    /**
     * Applies and saves the selected theme.
     */
    fun applyTheme(
        theme: String
    ) {

        val mode = when (theme) {

            THEME_LIGHT ->
                AppCompatDelegate.MODE_NIGHT_NO

            THEME_DARK ->
                AppCompatDelegate.MODE_NIGHT_YES

            else ->
                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        }

        AppCompatDelegate.setDefaultNightMode(mode)

        preferences.edit {
            putString(
                KEY_THEME,
                theme
            )
        }

        _currentTheme.value = theme
    }

    /**
     * Returns the saved theme.
     */
    fun getTheme(): String {
        return _currentTheme.value
    }

    /**
     * Loads the saved theme.
     */
    private fun loadTheme(): String {

        return preferences.getString(
            KEY_THEME,
            THEME_SYSTEM
        ) ?: THEME_SYSTEM
    }
}
