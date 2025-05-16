package com.chrisroid.fintrack.ui.main.expenses

import androidx.compose.foundation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chrisroid.fintrack.R
import com.chrisroid.fintrack.navigation.Routes
import com.chrisroid.fintrack.ui.theme.appText

@Composable
fun ExpensesScreen(onAllExpenses: () -> Unit, onSortExpenses: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Top Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "My Expenses",
                style = appText.copy(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
            Icon(
                imageVector = Icons.Default.MoreHoriz,
                contentDescription = "More",
                tint = Color(0xFFDADADA),
                modifier = Modifier
                    .size(30.dp)
                    .background(Color(0xFF130F26), shape = CircleShape)
                    .padding(6.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Summary
        ExpenseSummaryCard(
            amount = "₦ 1,000,500.55",
            subtitle = "spent in the last 7 days"
        )

        Spacer(modifier = Modifier.height(16.dp))

        SortExpensesCard(onClick = onSortExpenses)

        Spacer(modifier = Modifier.height(16.dp))

        // Header with View All
        Card(
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color(0xFFECECED)),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Transactions",
                        style = appText.copy(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    )
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFE0C7)),
                        modifier = Modifier.clickable { onAllExpenses() }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("View All", style = appText.copy(fontSize = 14.sp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(Icons.Default.ChevronRight, contentDescription = null)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                TransactionsGroup(
                    dateLabel = "Today, 14/07/2024",
                    transactions = listOf(
                        Triple("🍔", "Food & Drinks", "₦200,000.00"),
                        Triple("🚗", "Transportation", "₦50,000.00"),
                        Triple("🚗", "Transportation", "₦50,000.00")
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                TransactionsGroup(
                    dateLabel = "Yesterday, 13/07/2024",
                    transactions = listOf(
                        Triple("🍔", "Food & Drinks", "₦200,000.00"),
                        Triple("🍔", "Food & Drinks", "₦200,000.00"),
                        Triple("🍔", "Food & Drinks", "₦200,000.00"),
                        Triple("🍔", "Food & Drinks", "₦200,000.00"),
                        Triple("🍔", "Food & Drinks", "₦200,000.00"),
                        Triple("🍔", "Food & Drinks", "₦200,000.00"),
                        Triple("🍔", "Food & Drinks", "₦200,000.00"),
                        Triple("🍔", "Food & Drinks", "₦200,000.00"),
                        Triple("🍔", "Food & Drinks", "₦200,000.00"),
                        Triple("🍔", "Food & Drinks", "₦200,000.00"),
                        Triple("🍔", "Food & Drinks", "₦200,000.00"),
                        Triple("🍔", "Food & Drinks", "₦200,000.00"),
                    )
                )
            }
        }


        Spacer(modifier = Modifier.height(72.dp))
    }

    // FAB
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
        FloatingActionButton(
            onClick = { /* TODO */ },
            containerColor = Color(0xFFFF952B),
            shape = CircleShape,
            modifier = Modifier.padding(24.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add", tint = Color.White)
        }
    }
}


@Composable
fun ExpenseSummaryCard(amount: String, subtitle: String) {
    var isVisible by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.second_card),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Total expenses", style = appText.copy(fontSize = 14.sp))
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = if (isVisible) amount else "••••••••••",
                        style = appText.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = if (isVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Toggle visibility",
                        tint = Color(0xFF2B9D9B),
                        modifier = Modifier.clickable { isVisible = !isVisible }
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(subtitle, style = appText.copy(fontSize = 14.sp))
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(Color(0xFFFF952B), shape = RoundedCornerShape(2.dp))
                )
            }
        }
    }
}


@Composable
fun SortExpensesCard(onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFECECED)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Sort your expenses", style = appText.copy(fontSize = 16.sp))
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Edit",
                tint = Color(0xFF161B26),
                modifier = Modifier
                    .size(30.dp)
                    .background(Color(0xFFFFE6CC), shape = CircleShape)
                    .padding(6.dp)
            )
        }
    }
}


@Composable
fun TransactionRow(emoji: String, title: String, amount: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = emoji, fontSize = 24.sp)
            Spacer(modifier = Modifier.width(12.dp))
            Text(title, style = appText.copy(fontSize = 16.sp))
        }
        Text(amount, style = appText.copy(fontSize = 16.sp))
    }
}

@Composable
fun TransactionsGroup(dateLabel: String, transactions: List<Triple<String, String, String>>) {
    Column {
        Text(dateLabel, style = appText.copy(color = Color.Gray, fontSize = 14.sp))
        transactions.forEach { (emoji, title, amount) ->
            TransactionRow(emoji, title, amount)
        }
    }
}
