package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class Partnership(
    val firstBatsman: String,
    val secondBatsman: String,
    val runs: Int,
    val balls: Int,
    val fours: Int,
    val sixes: Int
)

@HiltViewModel
class PartnershipViewModel @Inject constructor() : ViewModel() {

    private val _partnership = MutableStateFlow(
        Partnership(
            firstBatsman = "Batsman 1",
            secondBatsman = "Batsman 2",
            runs = 52,
            balls = 38,
            fours = 6,
            sixes = 1
        )
    )

    val partnership: StateFlow<Partnership>
        get() = _partnership

    fun updatePartnership(
        runs: Int,
        balls: Int,
        fours: Int,
        sixes: Int
    ) {
        _partnership.value =
            _partnership.value.copy(
                runs = runs,
                balls = balls,
                fours = fours,
                sixes = sixes
            )
    }

    fun resetPartnership() {
        _partnership.value =
            _partnership.value.copy(
                runs = 0,
                balls = 0,
                fours = 0,
                sixes = 0
            )
    }
}
