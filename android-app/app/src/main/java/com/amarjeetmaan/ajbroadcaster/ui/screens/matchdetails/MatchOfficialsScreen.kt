package com.amarjeetmaan.ajbroadcaster.ui.screens.matchdetails

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

/**
 * Displays the officials assigned to a match.
 */
@Composable
fun MatchOfficialsScreen(
    navController: NavHostController,
    viewModel: MatchOfficialsViewModel = hiltViewModel()
) {

    val officials by viewModel.officials.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        AJTopBar(
            title = "Match Officials",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        LazyColumn(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(officials) { official ->

                AJCard {

                    Text(
                        text = official.role,
                        style = MaterialTheme.typography.labelMedium
                    )

                    Text(
                        text = official.name,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}
