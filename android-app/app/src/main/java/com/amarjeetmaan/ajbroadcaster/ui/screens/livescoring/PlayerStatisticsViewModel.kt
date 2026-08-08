package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class PlayerStatistics(
    val playerName: String = "Player 1",
    val matches: Int = 1,
    val runs: Int = 45,
    val ballsFaced: Int = 32,
    val fours: Int = 5,
    val sixes: Int = 2,
    val wickets: Int = 1,
    val ballsBowled: Int = 24,
    val runsConceded: Int = 18,
    val catches: Int = 1,
    val runOuts: Int = 0,
    val stumpings: Int = 0
) {
    val strikeRate: String
        get() = if (ballsFaced > 0) {
            "%.2f".format(
                runs.toDouble() * 100 / ballsFaced
            )
        } else {
            "0.00"
        }

    val oversBowled: String
        get() = "${ballsBowled / 6}.${ballsBowled % 6}"

    val economy: String
        get() = if (ballsBowled > 0) {
            "%.2f".format(
                runsConceded.toDouble() * 6 / ballsBowled
            )
        } else {
            "0.00"
        }
}

@HiltViewModel
class PlayerStatisticsViewModel @Inject constructor() : ViewModel() {

    private val _statistics = MutableStateFlow(
        PlayerStatistics()
    )

    val statistics: StateFlow<PlayerStatistics>
        get() = _statistics

    fun updateStatistics(
        playerName: String,
        matches: Int,
        runs: Int,
        ballsFaced: Int,
        fours: Int,
        sixes: Int,
        wickets: Int,
        ballsBowled: Int,
        runsConceded: Int,
        catches: Int,
        runOuts: Int,
        stumpings: Int
    ) {
        _statistics.value = PlayerStatistics(
            playerName = playerName.trim(),
            matches = matches.coerceAtLeast(0),
            runs = runs.coerceAtLeast(0),
            ballsFaced = ballsFaced.coerceAtLeast(0),
            fours = fours.coerceAtLeast(0),
            sixes = sixes.coerceAtLeast(0),
            wickets = wickets.coerceAtLeast(0),
            ballsBowled = ballsBowled.coerceAtLeast(0),
            runsConceded = runsConceded.coerceAtLeast(0),
            catches = catches.coerceAtLeast(0),
            runOuts = runOuts.coerceAtLeast(0),
            stumpings = stumpings.coerceAtLeast(0)
        )
    }

    fun reset() {
        _statistics.value = PlayerStatistics(
            playerName = "",
            matches = 0,
            runs = 0,
            ballsFaced = 0,
            fours = 0,
            sixes = 0,
            wickets = 0,
            ballsBowled = 0,
            runsConceded = 0,
            catches = 0,
            runOuts = 0,
            stumpings = 0
        )
    }
}
