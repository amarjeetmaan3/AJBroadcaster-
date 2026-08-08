package com.amarjeetmaan.ajbroadcaster.ui.screens.matchdetails

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class MatchSummary(
    val teamA: String,
    val teamAScore: String,
    val teamB: String,
    val teamBScore: String,
    val result: String
)

@HiltViewModel
class MatchSummaryViewModel @Inject constructor() : ViewModel() {

    private val _summary = MutableStateFlow(
        MatchSummary(
            teamA = "CSK",
            teamAScore = "125/4 (15.3)",
            teamB = "RCB",
            teamBScore = "120/8 (15.0)",
            result = "CSK won by 5 runs."
        )
    )

    val summary: StateFlow<MatchSummary>
        get() = _summary

    fun loadSummary(matchId: String) {
        // Match repository integration will be added later.
    }
}
