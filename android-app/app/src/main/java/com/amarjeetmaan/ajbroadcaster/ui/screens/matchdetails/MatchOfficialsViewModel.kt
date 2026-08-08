package com.amarjeetmaan.ajbroadcaster.ui.screens.matchdetails

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * Represents a match official.
 */
data class MatchOfficial(
    val name: String,
    val role: String
)

/**
 * ViewModel for MatchOfficialsScreen.
 */
@HiltViewModel
class MatchOfficialsViewModel @Inject constructor() : ViewModel() {

    private val _officials =
        MutableStateFlow(
            listOf(
                MatchOfficial(
                    name = "Official 1",
                    role = "Umpire"
                ),
                MatchOfficial(
                    name = "Official 2",
                    role = "Umpire"
                ),
                MatchOfficial(
                    name = "Official 3",
                    role = "Scorer"
                )
            )
        )

    val officials: StateFlow<List<MatchOfficial>>
        get() = _officials

    /**
     * Refreshes match officials.
     *
     * Backend integration will be
     * added when the match repository
     * is connected.
     */
    fun refreshOfficials() {
        // Reserved for future implementation.
    }
}
