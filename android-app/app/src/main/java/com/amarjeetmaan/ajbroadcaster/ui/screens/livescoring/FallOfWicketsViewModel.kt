package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class FallOfWicket(
    val wicketNumber: Int,
    val batter: String,
    val score: String,
    val overs: String
)

@HiltViewModel
class FallOfWicketsViewModel @Inject constructor() : ViewModel() {

    private val _wickets = MutableStateFlow(
        listOf(
            FallOfWicket(
                wicketNumber = 1,
                batter = "Batter 1",
                score = "32/1",
                overs = "4.2"
            ),
            FallOfWicket(
                wicketNumber = 2,
                batter = "Batter 2",
                score = "58/2",
                overs = "7.5"
            )
        )
    )

    val wickets: StateFlow<List<FallOfWicket>>
        get() = _wickets

    fun addWicket(
        batter: String,
        score: String,
        overs: String
    ) {
        val cleanBatter = batter.trim()

        if (cleanBatter.isEmpty()) {
            return
        }

        val wicketNumber = _wickets.value.size + 1

        _wickets.value = _wickets.value + FallOfWicket(
            wicketNumber = wicketNumber,
            batter = cleanBatter,
            score = score.trim(),
            overs = overs.trim()
        )
    }

    fun removeLastWicket() {
        if (_wickets.value.isEmpty()) {
            return
        }

        _wickets.value = _wickets.value.dropLast(1)
    }

    fun clearWickets() {
        _wickets.value = emptyList()
    }
}
