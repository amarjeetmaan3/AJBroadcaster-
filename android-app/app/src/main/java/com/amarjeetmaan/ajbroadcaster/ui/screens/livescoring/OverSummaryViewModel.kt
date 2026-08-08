package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class OverSummary(
    val overNumber: Int,
    val runs: Int,
    val wickets: Int,
    val extras: Int,
    val ballSummary: String
) {
    val total: Int
        get() = runs + extras
}

@HiltViewModel
class OverSummaryViewModel @Inject constructor() : ViewModel() {

    private val _overs = MutableStateFlow(
        listOf(
            OverSummary(
                overNumber = 1,
                runs = 7,
                wickets = 0,
                extras = 1,
                ballSummary = "0 1 4 0 1 W"
            ),
            OverSummary(
                overNumber = 2,
                runs = 10,
                wickets = 1,
                extras = 0,
                ballSummary = "4 0 2 W 0 4"
            )
        )
    )

    val overs: StateFlow<List<OverSummary>>
        get() = _overs

    fun addOver(
        runs: Int,
        wickets: Int,
        extras: Int,
        ballSummary: String
    ) {
        val nextOver = _overs.value.size + 1

        _overs.value = _overs.value +
            OverSummary(
                overNumber = nextOver,
                runs = runs.coerceAtLeast(0),
                wickets = wickets.coerceAtLeast(0),
                extras = extras.coerceAtLeast(0),
                ballSummary = ballSummary
            )
    }

    fun clearOvers() {
        _overs.value = emptyList()
    }
}
