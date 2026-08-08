package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class BallDelivery(
    val over: String,
    val description: String,
    val runs: Int
)

@HiltViewModel
class LiveBallByBallViewModel @Inject constructor() : ViewModel() {

    private val _deliveries = MutableStateFlow(
        listOf(
            BallDelivery(
                over = "1.1",
                description = "Dot ball",
                runs = 0
            ),
            BallDelivery(
                over = "1.2",
                description = "FOUR",
                runs = 4
            ),
            BallDelivery(
                over = "1.3",
                description = "Single",
                runs = 1
            )
        )
    )

    val deliveries: StateFlow<List<BallDelivery>>
        get() = _deliveries

    fun addDelivery(
        over: String,
        description: String,
        runs: Int
    ) {
        _deliveries.value =
            _deliveries.value +
                BallDelivery(
                    over = over,
                    description = description,
                    runs = runs
                )
    }

    fun clearDeliveries() {
        _deliveries.value = emptyList()
    }
}
