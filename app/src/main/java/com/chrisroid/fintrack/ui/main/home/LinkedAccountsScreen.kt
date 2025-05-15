package com.chrisroid.fintrack.ui.main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.ui.Modifier


@Composable
fun LinkedAccountsScreen(
    onAccountClick: (String) -> Unit
) {
    val accounts = listOf("Primary Checking", "Savings Account", "Investment Account")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text("Linked Accounts", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(accounts) { account ->
            Card(
                onClick = { onAccountClick(account) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(account, style = MaterialTheme.typography.titleLarge)
                    Text("•••• 1234 • $1,234.56")
                }
            }
        }
    }
}