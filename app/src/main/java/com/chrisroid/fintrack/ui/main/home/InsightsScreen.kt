package com.chrisroid.fintrack.ui.main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.ui.Modifier

@Composable
fun InsightsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Financial Insights", style = MaterialTheme.typography.headlineMedium)

        // Add your charts and insights here
        Spacer(modifier = Modifier.height(16.dp))

        // Example insight item
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Monthly Spending", style = MaterialTheme.typography.titleLarge)
                Text("$1,245.00 • 12% increase from last month")
            }
        }
    }
}