package com.chrisroid.fintrack.ui.main.expenses

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
fun ExpensesScreen(
    onAllExpenses: () -> Unit,
    onSortExpenses: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Expenses", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onAllExpenses,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View All Expenses")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onSortExpenses,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        ) {
            Text("Sort Expenses")
        }
    }
}