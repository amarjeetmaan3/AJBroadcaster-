package com.amarjeetmaan.ajbroadcaster.ui.screens.matchlist

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class MatchItem(
    val teamA: String,
    val teamB: String,
    val venue: String,
    val status: String
)

@HiltViewModel
class MatchListViewModel @Inject constructor() : ViewModel() {

    private val _matches =
        MutableStateFlow(
            listOf(
                MatchItem(
                    "CSK",
                    "RCB",
                    "Amargarh",
                    "Upcoming"
                ),
                MatchItem(
                    "SDW XI",
                    "HPMT",
                    "Amargarh",
                    "Live"
                )
            )
        )

    val matches: StateFlow<List<MatchItem>>
        get() = _matches

    fun refreshMatches() {
        // Repository integration later.
    }
}
