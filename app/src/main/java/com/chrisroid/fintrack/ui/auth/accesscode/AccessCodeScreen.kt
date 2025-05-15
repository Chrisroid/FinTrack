package com.chrisroid.fintrack.ui.auth.accesscode

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chrisroid.fintrack.navigation.Routes
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun AccessCodeScreen(navController: NavController) {
    var accessCode by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Enter Access Code", style = MaterialTheme.typography.headlineMedium)
        Text("Your organization provided this code", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = accessCode,
            onValueChange = { accessCode = it },
            label = { Text("Access Code") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate(Routes.ACCOUNT_SETUP) },
            modifier = Modifier.fillMaxWidth(),
            enabled = accessCode.isNotBlank()
        ) {
            Text("Continue")
        }
    }
}