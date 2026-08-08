package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class MatchAward(
    val title: String,
    val player: String
)

@HiltViewModel
class MatchAwardsViewModel @Inject constructor() : ViewModel() {

    private val _awards = MutableStateFlow(
        listOf(
            MatchAward(
                title = "Player of the Match",
                player = "Player 1"
            ),
            MatchAward(
                title = "Best Batter",
                player = "Player 2"
            ),
            MatchAward(
                title = "Best Bowler",
                player = "Player 3"
            )
        )
    )

    val awards: StateFlow<List<MatchAward>>
        get() = _awards

    fun updateAward(
        title: String,
        player: String
    ) {
        _awards.value = _awards.value.map { award ->
            if (award.title == title) {
                award.copy(player = player)
            } else {
                award
            }
        }
    }

    fun addAward(
        title: String,
        player: String
    ) {
        _awards.value = _awards.value +
            MatchAward(
                title = title,
                player = player
            )
    }
}
