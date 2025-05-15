package com.chrisroid.fintrack.ui.main.expenses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
fun AllExpensesScreen() {
    val expenses = listOf(
        "Groceries" to -85.32,
        "Salary" to 2500.00,
        "Rent" to -1200.00
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text("All Expenses", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(expenses) { (name, amount) ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(name, style = MaterialTheme.typography.titleLarge)
                    Text(
                        "$${"%.2f".format(amount)}",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = if (amount < 0) MaterialTheme.colorScheme.error
                            else MaterialTheme.colorScheme.primary
                        )
                    )
                }
            }
        }
    }
}