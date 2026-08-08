package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class FieldingPlayer(
    val name: String,
    val catches: Int = 0,
    val runOuts: Int = 0,
    val stumpings: Int = 0
) {
    val totalDismissals: Int
        get() = catches + runOuts + stumpings
}

@HiltViewModel
class FieldingCardViewModel @Inject constructor() : ViewModel() {

    private val _players = MutableStateFlow(
        listOf(
            FieldingPlayer(
                name = "Player 1",
                catches = 1
            ),
            FieldingPlayer(
                name = "Player 2",
                catches = 2,
                runOuts = 1
            )
        )
    )

    val players: StateFlow<List<FieldingPlayer>>
        get() = _players

    fun addPlayer(name: String) {
        val cleanName = name.trim()

        if (cleanName.isEmpty()) {
            return
        }

        _players.value = _players.value + FieldingPlayer(
            name = cleanName
        )
    }

    fun updatePlayer(
        name: String,
        catches: Int,
        runOuts: Int,
        stumpings: Int
    ) {
        val cleanName = name.trim()

        if (cleanName.isEmpty()) {
            return
        }

        val updated = FieldingPlayer(
            name = cleanName,
            catches = catches.coerceAtLeast(0),
            runOuts = runOuts.coerceAtLeast(0),
            stumpings = stumpings.coerceAtLeast(0)
        )

        _players.value = _players.value.map { player ->
            if (player.name == cleanName) {
                updated
            } else {
                player
            }
        }
    }

    fun removePlayer(name: String) {
        _players.value = _players.value.filterNot {
            it.name == name
        }
    }

    fun clearPlayers() {
        _players.value = emptyList()
    }
}
