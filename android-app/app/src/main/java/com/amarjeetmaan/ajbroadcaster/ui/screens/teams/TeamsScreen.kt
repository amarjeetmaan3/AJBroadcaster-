package com.amarjeetmaan.ajbroadcaster.ui.screens.teams

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
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTeamCard
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

/**
 * Displays the list of teams.
 */
@Composable
fun TeamsScreen(
    navController: NavHostController,
    viewModel: TeamsViewModel = hiltViewModel()
) {

    val teams by viewModel.teams.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        AJTopBar(
            title = "Teams",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(teams) { team ->

                AJTeamCard(
                    teamName = team.name,
                    captain = team.captain,
                    playerCount = team.playerCount
                )
            }
        }
    }
}
