package com.amarjeetmaan.ajbroadcaster.ui.screens.matchdetails

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * ViewModel for PlayingXISelectionScreen.
 *
 * Maintains the available squad and
 * selected Playing XI.
 */
@HiltViewModel
class PlayingXIViewModel @Inject constructor() : ViewModel() {

    private val _players =
        MutableStateFlow(
            List(15) { index ->
                "Player ${index + 1}"
            }
        )

    val players: StateFlow<List<String>>
        get() = _players

    private val _selectedPlayers =
        MutableStateFlow<List<String>>(emptyList())

    val selectedPlayers: StateFlow<List<String>>
        get() = _selectedPlayers

    /**
     * Adds or removes a player.
     *
     * A Playing XI cannot contain
     * more than eleven players.
     */
    fun togglePlayer(player: String) {

        val current =
            _selectedPlayers.value.toMutableList()

        if (player in current) {
            current.remove(player)
        } else if (current.size < 11) {
            current.add(player)
        }

        _selectedPlayers.value = current
    }

    fun clearSelection() {
        _selectedPlayers.value = emptyList()
    }
}
