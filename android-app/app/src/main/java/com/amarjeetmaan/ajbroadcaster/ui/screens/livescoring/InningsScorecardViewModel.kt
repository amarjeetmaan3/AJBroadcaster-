package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class InningsScore(
    val teamName: String,
    val score: String,
    val overs: String,
    val runRate: String
)

@HiltViewModel
class InningsScorecardViewModel @Inject constructor() : ViewModel() {

    private val _innings = MutableStateFlow(
        listOf(
            InningsScore(
                teamName = "CSK",
                score = "125/4",
                overs = "15.3",
                runRate = "8.06"
            ),
            InningsScore(
                teamName = "RCB",
                score = "120/8",
                overs = "15.0",
                runRate = "8.00"
            )
        )
    )

    val innings: StateFlow<List<InningsScore>>
        get() = _innings

    fun updateInnings(
        teamName: String,
        score: String,
        overs: String,
        runRate: String
    ) {

        val updated = _innings.value
            .map { innings ->

                if (innings.teamName == teamName) {
                    innings.copy(
                        score = score,
                        overs = overs,
                        runRate = runRate
                    )
                } else {
                    innings
                }
            }

        _innings.value = updated
    }
}
