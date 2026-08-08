package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class MatchResult(
    val result: String,
    val winner: String,
    val margin: String,
    val playerOfMatch: String
)

@HiltViewModel
class MatchResultViewModel @Inject constructor() : ViewModel() {

    private val _result = MutableStateFlow(
        MatchResult(
            result = "Match Completed",
            winner = "CSK",
            margin = "5 runs",
            playerOfMatch = "Player 1"
        )
    )

    val result: StateFlow<MatchResult>
        get() = _result

    fun setResult(
        result: String,
        winner: String,
        margin: String,
        playerOfMatch: String
    ) {
        _result.value = MatchResult(
            result = result,
            winner = winner,
            margin = margin,
            playerOfMatch = playerOfMatch
        )
    }

    fun reset() {
        _result.value = MatchResult(
            result = "Match Not Completed",
            winner = "",
            margin = "",
            playerOfMatch = ""
        )
    }
}
