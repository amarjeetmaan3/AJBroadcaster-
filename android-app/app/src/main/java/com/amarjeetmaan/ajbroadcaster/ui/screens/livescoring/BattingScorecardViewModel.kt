package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class BatsmanScore(
    val name: String,
    val runs: Int,
    val balls: Int,
    val fours: Int,
    val sixes: Int,
    val strikeRate: String
)

@HiltViewModel
class BattingScorecardViewModel @Inject constructor() : ViewModel() {

    private val _batsmen = MutableStateFlow(
        listOf(
            BatsmanScore(
                name = "Batsman 1",
                runs = 45,
                balls = 32,
                fours = 5,
                sixes = 1,
                strikeRate = "140.63"
            ),
            BatsmanScore(
                name = "Batsman 2",
                runs = 28,
                balls = 21,
                fours = 3,
                sixes = 0,
                strikeRate = "133.33"
            )
        )
    )

    val batsmen: StateFlow<List<BatsmanScore>>
        get() = _batsmen

    fun refreshScorecard() {
        // Live score repository integration later.
    }
}
