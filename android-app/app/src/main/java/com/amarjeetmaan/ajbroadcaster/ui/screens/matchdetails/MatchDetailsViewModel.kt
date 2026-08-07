package com.amarjeetmaan.ajbroadcaster.ui.screens.matchdetails

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * ViewModel for MatchDetailsScreen.
 *
 * Responsible for loading match
 * information, squads, officials,
 * toss details, and statistics.
 */
@HiltViewModel
class MatchDetailsViewModel @Inject constructor() : ViewModel() {

    private val _loading =
        MutableStateFlow(false)

    val loading: StateFlow<Boolean>
        get() = _loading

    /**
     * Loads complete match details.
     *
     * Repository integration will
     * be implemented later.
     */
    fun loadMatch(
        matchId: String
    ) {
        _loading.value = true

        // Repository call placeholder.

        _loading.value = false
    }
}
