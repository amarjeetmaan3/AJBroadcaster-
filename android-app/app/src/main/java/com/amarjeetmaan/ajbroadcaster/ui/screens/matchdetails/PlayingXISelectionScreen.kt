package com.amarjeetmaan.ajbroadcaster.ui.screens.matchdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Playing XI selection screen.
 *
 * Allows the scorer to select the
 * eleven players who will play.
 */
@Composable
fun PlayingXISelectionScreen(
    viewModel: PlayingXIViewModel = hiltViewModel()
) {

    val players by viewModel.players.collectAsState()
    val selectedPlayers by viewModel.selectedPlayers.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Playing XI",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "${selectedPlayers.size}/11 players selected"
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            items(players) { player ->

                val selected =
                    player in selectedPlayers

                androidx.compose.foundation.layout.Row {

                    Checkbox(
                        checked = selected,
                        onCheckedChange = {
                            viewModel.togglePlayer(player)
                        }
                    )

                    Text(
                        text = player,
                        modifier = Modifier.padding(top = 12.dp)
                    )
                }
            }
        }
    }
}
