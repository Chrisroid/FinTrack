package com.chrisroid.fintrack.ui.main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chrisroid.fintrack.navigation.Routes

@Composable
fun HomeScreen(
    onInsightsClick: () -> Unit,
    onLinkedAccountsClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Dashboard", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        // Insights Card
        Card(
            onClick = onInsightsClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Financial Insights", style = MaterialTheme.typography.titleLarge)
                Text("View your spending patterns")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Linked Accounts Card
        Card(
            onClick = onLinkedAccountsClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Linked Accounts", style = MaterialTheme.typography.titleLarge)
                Text("Manage your connected accounts")
            }
        }
    }
}