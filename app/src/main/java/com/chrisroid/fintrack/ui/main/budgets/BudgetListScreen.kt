package com.chrisroid.fintrack.ui.main.budgets

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
fun BudgetListScreen(onBudgetClick: (String) -> Unit) {
    val budgets = listOf(
        "Groceries" to 500.0,
        "Entertainment" to 200.0,
        "Utilities" to 300.0
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text("All Budgets", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(budgets) { (name, amount) ->
            Card(
                onClick = { onBudgetClick(name) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(name, style = MaterialTheme.typography.titleLarge)
                    Text("$${"%.2f".format(amount)}", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}