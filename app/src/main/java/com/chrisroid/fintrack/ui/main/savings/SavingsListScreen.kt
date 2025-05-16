package com.chrisroid.fintrack.ui.main.savings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import com.chrisroid.fintrack.R

@Composable
fun SavingsListScreen(onSavingsClick: (String) -> Unit) {
//    val savingsGoals = listOf(
//        SavingsGoal("Vacation Fund", 1250.0, 5000.0, "₦ 500,000.00", R.drawable.kenya),
//        SavingsGoal("Emergency Fund", 3000.0, 10000.0, "₦ 500,000.00", R.drawable.kenya),
//        SavingsGoal("New Car", 500.0, 25000.0, "₦ 500,000.00", R.drawable.kenya)
//    )
//
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        item {
//            Text("My Savings Goals", style = MaterialTheme.typography.headlineMedium)
//            Spacer(modifier = Modifier.height(16.dp))
//        }
//
//        items(savingsGoals) { goal ->
//            SavingsGoalItem(goal = goal, onClick = { onSavingsClick(goal.name) })
//            Spacer(modifier = Modifier.height(8.dp))
//        }
//    }
}

//@Composable
//fun SavingsGoalItem(goal: SavingsGoal, onClick: () -> Unit) {
//    Card(
//        onClick = onClick,
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(goal.name, style = MaterialTheme.typography.titleLarge)
//                Text(
//                    "${(goal.currentAmount / goal.targetAmount * 100).toInt()}%",
//                    style = MaterialTheme.typography.titleLarge.copy(
//                        color = MaterialTheme.colorScheme.primary
//                    )
//                )
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text("Saved: $${"%.2f".format(goal.currentAmount)}")
//                Text("Target: $${"%.2f".format(goal.targetAmount)}")
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            LinearProgressIndicator(
//                progress = (goal.currentAmount / goal.targetAmount).toFloat(),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(8.dp),
//                color = MaterialTheme.colorScheme.primary
//            )
//        }
//    }

//
//data class SavingsGoal(
//    val name: String,
//    val currentAmount: Double,
//    val targetAmount: String,
//    val s: String,
//    val kenya: Int
//)