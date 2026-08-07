package com.amarjeetmaan.ajbroadcaster.ui.screens.players

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class PlayerItem(
    val name: String,
    val role: String,
    val stats: String
)

@HiltViewModel
class PlayersViewModel @Inject constructor() : ViewModel() {

    private val _players =
        MutableStateFlow(
            listOf(
                PlayerItem(
                    "Virat Kohli",
                    "Batter",
                    "8,000 Runs"
                ),
                PlayerItem(
                    "Jasprit Bumrah",
                    "Bowler",
                    "300 Wickets"
                )
            )
        )

    val players: StateFlow<List<PlayerItem>>
        get() = _players

    /**
     * Refresh player list.
     */
    fun refreshPlayers() {
        // Repository integration later.
    }
}
