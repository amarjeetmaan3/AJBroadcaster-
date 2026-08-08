package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class ExtrasScore(
    val wides: Int,
    val noBalls: Int,
    val byes: Int,
    val legByes: Int,
    val penalty: Int
) {
    val total: Int
        get() = wides + noBalls + byes + legByes + penalty
}

@HiltViewModel
class ExtrasViewModel @Inject constructor() : ViewModel() {

    private val _extras = MutableStateFlow(
        ExtrasScore(
            wides = 2,
            noBalls = 1,
            byes = 1,
            legByes = 2,
            penalty = 0
        )
    )

    val extras: StateFlow<ExtrasScore>
        get() = _extras

    fun updateExtras(
        wides: Int,
        noBalls: Int,
        byes: Int,
        legByes: Int,
        penalty: Int
    ) {
        _extras.value = ExtrasScore(
            wides = wides.coerceAtLeast(0),
            noBalls = noBalls.coerceAtLeast(0),
            byes = byes.coerceAtLeast(0),
            legByes = legByes.coerceAtLeast(0),
            penalty = penalty.coerceAtLeast(0)
        )
    }

    fun resetExtras() {
        _extras.value = ExtrasScore(
            wides = 0,
            noBalls = 0,
            byes = 0,
            legByes = 0,
            penalty = 0
        )
    }
}
