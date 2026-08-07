package com.amarjeetmaan.ajbroadcaster.ui.screens.tournament

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

/**
 * Tournament list screen.
 */
@Composable
fun TournamentScreen(
    navController: NavHostController,
    viewModel: TournamentViewModel = hiltViewModel()
) {

    val tournaments by viewModel.tournaments.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        AJTopBar(
            title = "Tournaments",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(16.dp)
        ) {

            items(tournaments) { tournament ->

                AJCard {

                    Text(
                        text = tournament,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}
