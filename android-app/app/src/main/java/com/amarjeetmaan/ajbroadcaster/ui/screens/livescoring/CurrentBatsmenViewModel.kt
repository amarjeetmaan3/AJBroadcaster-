package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class CurrentBatsman(
    val name: String,
    val runs: Int,
    val balls: Int,
    val fours: Int,
    val sixes: Int,
    val strikeRate: String,
    val isStriker: Boolean
)

@HiltViewModel
class CurrentBatsmenViewModel @Inject constructor() : ViewModel() {

    private val _batsmen = MutableStateFlow(
        listOf(
            CurrentBatsman(
                name = "Batsman 1",
                runs = 42,
                balls = 28,
                fours = 5,
                sixes = 1,
                strikeRate = "150.00",
                isStriker = true
            ),
            CurrentBatsman(
                name = "Batsman 2",
                runs = 19,
                balls = 17,
                fours = 2,
                sixes = 0,
                strikeRate = "111.76",
                isStriker = false
            )
        )
    )

    val batsmen: StateFlow<List<CurrentBatsman>>
        get() = _batsmen

    fun setStriker(playerName: String) {
        _batsmen.value = _batsmen.value.map {
            it.copy(
                isStriker = it.name == playerName
            )
        }
    }

    fun updateBatsman(
        playerName: String,
        runs: Int,
        balls: Int,
        fours: Int,
        sixes: Int
    ) {
        _batsmen.value = _batsmen.value.map { batsman ->

            if (batsman.name == playerName) {

                val strikeRate =
                    if (balls > 0) {
                        "%.2f".format(
                            (runs.toDouble() / balls) * 100
                        )
                    } else {
                        "0.00"
                    }

                batsman.copy(
                    runs = runs,
                    balls = balls,
                    fours = fours,
                    sixes = sixes,
                    strikeRate = strikeRate
                )
            } else {
                batsman
            }
        }
    }
}
