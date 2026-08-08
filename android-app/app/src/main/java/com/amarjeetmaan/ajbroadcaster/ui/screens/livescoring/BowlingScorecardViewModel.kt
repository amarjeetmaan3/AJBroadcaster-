package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class BowlerScore(
    val name: String,
    val overs: String,
    val runs: Int,
    val wickets: Int,
    val economy: String,
    val dots: Int
)

@HiltViewModel
class BowlingScorecardViewModel @Inject constructor() : ViewModel() {

    private val _bowlers = MutableStateFlow(
        listOf(
            BowlerScore(
                name = "Bowler 1",
                overs = "4.0",
                runs = 24,
                wickets = 2,
                economy = "6.00",
                dots = 12
            ),
            BowlerScore(
                name = "Bowler 2",
                overs = "3.0",
                runs = 18,
                wickets = 1,
                economy = "6.00",
                dots = 9
            )
        )
    )

    val bowlers: StateFlow<List<BowlerScore>>
        get() = _bowlers

    fun refreshScorecard() {
        // Live score repository integration later.
    }
}
