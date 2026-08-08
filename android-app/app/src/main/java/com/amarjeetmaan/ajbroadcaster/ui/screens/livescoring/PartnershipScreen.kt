package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amarjeetmaan.ajbroadcaster.ui.components.AJCard
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

@Composable
fun PartnershipScreen(
    navController: NavHostController,
    viewModel: PartnershipViewModel = hiltViewModel()
) {

    val partnership by viewModel.partnership.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        AJTopBar(
            title = "Partnership",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        AJCard {

            Text(
                text = "Current Partnership",
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = "${partnership.runs} runs"
            )

            Text(
                text = "${partnership.balls} balls"
            )

            Text(
                text = "${partnership.fours} fours • ${partnership.sixes} sixes"
            )

            Text(
                text = "${partnership.firstBatsman} & ${partnership.secondBatsman}"
            )
        }
    }
}
