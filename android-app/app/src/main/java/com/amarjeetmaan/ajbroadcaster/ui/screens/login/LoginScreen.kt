package com.amarjeetmaan.ajbroadcaster.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.amarjeetmaan.ajbroadcaster.ui.components.AJButton
import com.amarjeetmaan.ajbroadcaster.ui.components.AJTextField
import com.amarjeetmaan.ajbroadcaster.ui.navigation.NavigationDestination

/**
 * Login screen for AJ Broadcaster.
 *
 * Authentication logic will be
 * connected in future phases.
 */
@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AJTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = "Email"
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        AJTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = "Password",
            password = true
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        AJButton(
            text = "Login",
            onClick = {

                navController.navigate(
                    NavigationDestination.Dashboard.route
                )
            }
        )
    }
}
