package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class CurrentBowler(
    val name: String,
    val overs: String,
    val runs: Int,
    val wickets: Int,
    val economy: String,
    val dots: Int
)

@HiltViewModel
class CurrentBowlerViewModel @Inject constructor() : ViewModel() {

    private val _bowler = MutableStateFlow(
        CurrentBowler(
            name = "Bowler 1",
            overs = "3.2",
            runs = 18,
            wickets = 1,
            economy = "5.40",
            dots = 11
        )
    )

    val bowler: StateFlow<CurrentBowler>
        get() = _bowler

    fun updateBowler(
        name: String,
        overs: String,
        runs: Int,
        wickets: Int,
        dots: Int
    ) {

        val balls =
            oversToBalls(overs)

        val economy =
            if (balls > 0) {
                "%.2f".format(
                    runs.toDouble() * 6 / balls
                )
            } else {
                "0.00"
            }

        _bowler.value = CurrentBowler(
            name = name,
            overs = overs,
            runs = runs,
            wickets = wickets,
            economy = economy,
            dots = dots
        )
    }

    private fun oversToBalls(
        overs: String
    ): Int {

        val parts = overs.split(".")

        if (parts.size != 2) {
            return 0
        }

        val completedOvers =
            parts[0].toIntOrNull() ?: return 0

        val balls =
            parts[1].toIntOrNull() ?: return 0

        return (completedOvers * 6) + balls
    }
}
