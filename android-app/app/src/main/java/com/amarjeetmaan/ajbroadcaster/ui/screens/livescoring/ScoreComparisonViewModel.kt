package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class ScoreComparison(
    val teamA: String,
    val teamAScore: String,
    val teamAOvers: String,
    val teamARunRate: String,
    val teamB: String,
    val teamBScore: String,
    val teamBOvers: String,
    val teamBRunRate: String
)

@HiltViewModel
class ScoreComparisonViewModel @Inject constructor() : ViewModel() {

    private val _comparison = MutableStateFlow(
        ScoreComparison(
            teamA = "CSK",
            teamAScore = "125/4",
            teamAOvers = "15.3",
            teamARunRate = "8.06",
            teamB = "RCB",
            teamBScore = "120/8",
            teamBOvers = "15.0",
            teamBRunRate = "8.00"
        )
    )

    val comparison: StateFlow<ScoreComparison>
        get() = _comparison

    fun updateComparison(
        teamA: String,
        teamAScore: String,
        teamAOvers: String,
        teamARunRate: String,
        teamB: String,
        teamBScore: String,
        teamBOvers: String,
        teamBRunRate: String
    ) {
        _comparison.value = ScoreComparison(
            teamA = teamA,
            teamAScore = teamAScore,
            teamAOvers = teamAOvers,
            teamARunRate = teamARunRate,
            teamB = teamB,
            teamBScore = teamBScore,
            teamBOvers = teamBOvers,
            teamBRunRate = teamBRunRate
        )
    }
}
