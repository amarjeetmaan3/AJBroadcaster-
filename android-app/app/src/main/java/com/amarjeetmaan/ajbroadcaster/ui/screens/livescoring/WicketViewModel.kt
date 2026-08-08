package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class WicketEvent(
    val number: Int,
    val batter: String,
    val bowler: String,
    val dismissal: String,
    val ball: String
)

@HiltViewModel
class WicketViewModel @Inject constructor() : ViewModel() {

    private val _wickets = MutableStateFlow(
        listOf(
            WicketEvent(
                number = 1,
                batter = "Batsman 1",
                bowler = "Bowler 1",
                dismissal = "Caught",
                ball = "7.3"
            )
        )
    )

    val wickets: StateFlow<List<WicketEvent>>
        get() = _wickets

    fun addWicket(
        batter: String,
        bowler: String,
        dismissal: String,
        ball: String
    ) {
        val nextNumber =
            _wickets.value.size + 1

        _wickets.value =
            _wickets.value +
                WicketEvent(
                    number = nextNumber,
                    batter = batter,
                    bowler = bowler,
                    dismissal = dismissal,
                    ball = ball
                )
    }

    fun removeLastWicket() {
        if (_wickets.value.isNotEmpty()) {
            _wickets.value =
                _wickets.value.dropLast(1)
        }
    }

    fun clearWickets() {
        _wickets.value = emptyList()
    }
}
