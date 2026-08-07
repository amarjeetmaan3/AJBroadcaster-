package com.amarjeetmaan.ajbroadcaster.ui.screens.matchlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amarjeetmaan.ajbroadcaster.ui.components.AJMatchCard
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar
import com.amarjeetmaan.ajbroadcaster.ui.navigation.NavigationDestination

/**
 * Displays the list of available matches.
 */
@Composable
fun MatchListScreen(
    navController: NavHostController,
    viewModel: MatchListViewModel = hiltViewModel()
) {

    val matches by viewModel.matches.collectAsState()

    Column {

        AJTopBar(
            title = "Matches",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(16.dp)
        ) {

            items(matches) { match ->

                AJMatchCard(
                    teamA = match.teamA,
                    teamB = match.teamB,
                    matchStatus = match.status,
                    venue = match.venue,
                    modifier = Modifier.clickable {
                        navController.navigate(
                            NavigationDestination.MatchDetails.route
                        )
                    }
                )
            }
        }
    }
}
