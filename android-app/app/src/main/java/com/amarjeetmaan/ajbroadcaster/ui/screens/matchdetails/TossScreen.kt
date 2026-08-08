package com.amarjeetmaan.ajbroadcaster.ui.screens.matchdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

/**
 * Toss management screen.
 *
 * Records the toss winner and
 * the decision to bat or field.
 */
@Composable
fun TossScreen(
    navController: NavHostController
) {

    var tossWinner by remember {
        mutableStateOf<String?>(null)
    }

    var decision by remember {
        mutableStateOf<String?>(null)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Toss",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "Toss Winner: ${tossWinner ?: "Not selected"}"
        )

        Button(
            onClick = {
                tossWinner = "Team A"
            }
        ) {
            Text("Team A Won Toss")
        }

        Button(
            onClick = {
                tossWinner = "Team B"
            }
        ) {
            Text("Team B Won Toss")
        }

        Text(
            text = "Decision: ${decision ?: "Not selected"}"
        )

        Button(
            onClick = {
                decision = "Bat"
            }
        ) {
            Text("Bat")
        }

        Button(
            onClick = {
                decision = "Field"
            }
        ) {
            Text("Field")
        }
    }
}
