package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun BattingCardScreen(
    navController: NavHostController,
    viewModel: BattingCardViewModel = hiltViewModel()
) {
    val batters by viewModel.batters.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AJTopBar(
            title = "Batting Card",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(batters) { batter ->
                AJCard {
                    Text(text = batter.name)
                    Text(text = "Runs: ${batter.runs}")
                    Text(text = "Balls: ${batter.balls}")
                    Text(text = "4s: ${batter.fours}")
                    Text(text = "6s: ${batter.sixes}")
                    Text(text = "SR: ${batter.strikeRate}")
                    Text(text = "Status: ${batter.status}")
                }
            }
        }
    }
}
