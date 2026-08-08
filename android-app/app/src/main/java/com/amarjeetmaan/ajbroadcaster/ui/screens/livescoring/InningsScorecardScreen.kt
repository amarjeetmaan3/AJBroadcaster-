package com.amarjeetmaan.ajbroadcaster.ui.screens.livescoring

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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

@Composable
fun InningsScorecardScreen(
    navController: NavHostController,
    viewModel: InningsScorecardViewModel = hiltViewModel()
) {

    val innings by viewModel.innings.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        AJTopBar(
            title = "Innings Scorecard",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(innings) { item ->

                AJCard {

                    Text(
                        text = item.teamName,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        text = "Score: ${item.score}"
                    )

                    Text(
                        text = "Overs: ${item.overs}"
                    )

                    Text(
                        text = "Run Rate: ${item.runRate}"
                    )
                }
            }
        }
    }
}
