package com.amarjeetmaan.ajbroadcaster.ui.screens.players

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amarjeetmaan.ajbroadcaster.ui.components.AJPlayerCard
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

/**
 * Displays the list of players.
 */
@Composable
fun PlayersScreen(
    navController: NavHostController,
    viewModel: PlayersViewModel = hiltViewModel()
) {

    val players by viewModel.players.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        AJTopBar(
            title = "Players",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(players) { player ->

                AJPlayerCard(
                    playerName = player.name,
                    role = player.role,
                    stats = player.stats
                )
            }
        }
    }
}
