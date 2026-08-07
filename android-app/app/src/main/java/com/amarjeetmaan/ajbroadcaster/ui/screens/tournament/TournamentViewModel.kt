package com.amarjeetmaan.ajbroadcaster.ui.screens.tournament

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * ViewModel for TournamentScreen.
 */
@HiltViewModel
class TournamentViewModel @Inject constructor() : ViewModel() {

    private val _tournaments =
        MutableStateFlow(
            listOf(
                "Amargarh Premier League",
                "Village Super Cup"
            )
        )

    val tournaments: StateFlow<List<String>>
        get() = _tournaments

    /**
     * Refresh tournament list.
     */
    fun refresh() {
        // Repository integration later.
    }
}
