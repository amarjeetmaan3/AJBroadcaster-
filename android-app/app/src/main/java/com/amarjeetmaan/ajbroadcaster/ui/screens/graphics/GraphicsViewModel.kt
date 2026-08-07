package com.amarjeetmaan.ajbroadcaster.ui.screens.graphics

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * ViewModel for GraphicsScreen.
 *
 * Controls broadcast graphics,
 * overlays, animations, and
 * graphic templates.
 */
@HiltViewModel
class GraphicsViewModel @Inject constructor() : ViewModel() {

    private val _overlayVisible =
        MutableStateFlow(false)

    val overlayVisible: StateFlow<Boolean>
        get() = _overlayVisible

    /**
     * Shows score overlay.
     */
    fun showOverlay() {
        _overlayVisible.value = true
    }

    /**
     * Hides score overlay.
     */
    fun hideOverlay() {
        _overlayVisible.value = false
    }

    /**
     * Toggles overlay visibility.
     */
    fun toggleOverlay() {
        _overlayVisible.value =
            !_overlayVisible.value
    }
}
