package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class MatchDetails(
    val leagueName: String = "Amargarh Premium League 2026",
    val matchNumber: String = "Match 1",
    val matchType: String = "League Match",
    val teamA: String = "Team A",
    val teamB: String = "Team B",
    val venue: String = "Amargarh",
    val date: String = "",
    val time: String = "",
    val overs: Int = 15
)

@HiltViewModel
class MatchDetailsViewModel @Inject constructor() : ViewModel() {

    private val _details = MutableStateFlow(
        MatchDetails()
    )

    val details: StateFlow<MatchDetails>
        get() = _details

    fun updateDetails(
        leagueName: String,
        matchNumber: String,
        matchType: String,
        teamA: String,
        teamB: String,
        venue: String,
        date: String,
        time: String,
        overs: Int
    ) {
        _details.value = MatchDetails(
            leagueName = leagueName.trim(),
            matchNumber = matchNumber.trim(),
            matchType = matchType.trim(),
            teamA = teamA.trim(),
            teamB = teamB.trim(),
            venue = venue.trim(),
            date = date.trim(),
            time = time.trim(),
            overs = overs.coerceAtLeast(1)
        )
    }

    fun setTeams(
        teamA: String,
        teamB: String
    ) {
        _details.value = _details.value.copy(
            teamA = teamA.trim(),
            teamB = teamB.trim()
        )
    }

    fun reset() {
        _details.value = MatchDetails(
            leagueName = "",
            matchNumber = "",
            matchType = "",
            teamA = "",
            teamB = "",
            venue = "",
            date = "",
            time = "",
            overs = 15
        )
    }
}
