package com.amarjeetmaan.ajbroadcaster.ui.screens.graphics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.amarjeetmaan.ajbroadcaster.ui.components.AJButton
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTopBar

/**
 * Graphics control screen.
 *
 * Used for triggering score overlays,
 * wickets, boundaries, player cards,
 * and broadcast graphics.
 */
@Composable
fun GraphicsScreen(
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        AJTopBar(
            title = "Graphics",
            showBackButton = true,
            onBackClick = {
                navController.popBackStack()
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Graphics Control Panel",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(24.dp))

        AJButton(
            text = "Show Score Overlay",
            onClick = {
                // GraphicsManager integration later.
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        AJButton(
            text = "Hide All Graphics",
            onClick = {
                // GraphicsManager integration later.
            }
        )
    }
}
