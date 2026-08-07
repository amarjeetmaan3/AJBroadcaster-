package com.amarjeetmaan.ajbroadcaster.ui.screens.teams

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class TeamItem(
    val name: String,
    val captain: String,
    val playerCount: Int
)

@HiltViewModel
class TeamsViewModel @Inject constructor() : ViewModel() {

    private val _teams =
        MutableStateFlow(
            listOf(
                TeamItem(
                    name = "CSK",
                    captain = "MS Dhoni",
                    playerCount = 15
                ),
                TeamItem(
                    name = "RCB",
                    captain = "Virat Kohli",
                    playerCount = 15
                )
            )
        )

    val teams: StateFlow<List<TeamItem>>
        get() = _teams

    /**
     * Refreshes team list.
     *
     * Repository integration
     * will be added later.
     */
    fun refreshTeams() {
        // Reserved for future implementation.
    }
}
