package com.amarjeetmaan.ajbroadcaster.ui.screens.streaming

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * ViewModel for StreamingScreen.
 */
@HiltViewModel
class StreamingViewModel @Inject constructor() : ViewModel() {

    private val _isStreaming =
        MutableStateFlow(false)

    val isStreaming: StateFlow<Boolean>
        get() = _isStreaming

    fun setStreaming(
        enabled: Boolean
    ) {
        _isStreaming.value = enabled
    }

    fun toggleStreaming() {
        _isStreaming.value =
            !_isStreaming.value
    }
}
