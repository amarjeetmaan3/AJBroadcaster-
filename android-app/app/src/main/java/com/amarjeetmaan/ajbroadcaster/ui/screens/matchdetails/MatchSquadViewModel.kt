package com.amarjeetmaan.ajbroadcaster.ui.screens.matchdetails

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * ViewModel for MatchSquadScreen.
 */
@HiltViewModel
class MatchSquadViewModel @Inject constructor() : ViewModel() {

    private val _players =
        MutableStateFlow<List<String>>(emptyList())

    val players: StateFlow<List<String>>
        get() = _players

    /**
     * Loads the squad for a match.
     *
     * Match repository integration
     * will be added later.
     */
    fun loadSquad(matchId: String) {
        _players.value = emptyList()
    }
}
