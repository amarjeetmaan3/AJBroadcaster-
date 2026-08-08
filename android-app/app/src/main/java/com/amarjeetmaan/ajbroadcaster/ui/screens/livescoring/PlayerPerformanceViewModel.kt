package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class PlayerPerformance(
    val playerName: String,
    val runs: Int,
    val wickets: Int,
    val catches: Int,
    val performanceScore: Int
)

@HiltViewModel
class PlayerPerformanceViewModel @Inject constructor() : ViewModel() {

    private val _performances = MutableStateFlow(
        listOf(
            PlayerPerformance(
                playerName = "Player 1",
                runs = 72,
                wickets = 1,
                catches = 2,
                performanceScore = 91
            ),
            PlayerPerformance(
                playerName = "Player 2",
                runs = 25,
                wickets = 3,
                catches = 1,
                performanceScore = 84
            )
        )
    )

    val performances: StateFlow<List<PlayerPerformance>>
        get() = _performances

    fun updatePerformance(
        playerName: String,
        runs: Int,
        wickets: Int,
        catches: Int
    ) {
        _performances.value = _performances.value.map { player ->
            if (player.playerName == playerName) {
                player.copy(
                    runs = runs,
                    wickets = wickets,
                    catches = catches,
                    performanceScore =
                        runs + (wickets * 20) + (catches * 10)
                )
            } else {
                player
            }
        }
    }
}
