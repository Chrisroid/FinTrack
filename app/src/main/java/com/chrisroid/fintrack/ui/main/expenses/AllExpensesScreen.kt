package com.chrisroid.fintrack.ui.main.expenses

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.chrisroid.fintrack.R
import androidx.compose.ui.unit.sp
import com.chrisroid.fintrack.ui.theme.appText

@Composable
fun AllExpensesScreen() {
    val transactions = listOf(
        "Today, 14/07/2024" to listOf(
            Triple("🍔", "Food & Drinks", "₦200,000.00"),
            Triple("🚗", "Transportation", "₦50,000.00"),
            Triple("🚗", "Transportation", "₦50,000.00")
        ),
        "Yesterday, 13/07/2024" to listOf(
            Triple("🍔", "Food & Drinks", "₦200,000.00"),
            Triple("🚗", "Transportation", "₦50,000.00"),
            Triple("🚗", "Transportation", "₦50,000.00")
        )
    )

    LazyColumn(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        item {
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ChevronLeft,
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(30.dp)
                        .background(Color(0xFFFFE6CC), shape = CircleShape)
                        .padding(6.dp)
                        .clickable { /* TODO: handle back press */ }
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Transactions",
                    style = appText.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.weight(1f)) // balances the row

                Icon(
                    painter = painterResource(id = R.drawable.ic_filter),
                    contentDescription = "Filter"
                )
            }


            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search", style = appText.copy(color = Color.Gray, fontSize = 18.sp)) },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.LightGray,
                    focusedBorderColor = Color(0xFF2B9D9B)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        transactions.forEach { (date, items) ->
            item {
                Text(date, style = appText.copy(color = Color.Gray, fontSize = 14.sp))
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(items) { (emoji, label, amount) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(shape = CircleShape, color = Color(0xFFF5F5F5)) {
                            Text(emoji, fontSize = 24.sp, modifier = Modifier.padding(6.dp))
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(label, style = appText.copy(fontSize = 16.sp))
                    }
                    Text(amount, style = appText.copy(fontSize = 16.sp))
                }
            }
        }

        item { Spacer(modifier = Modifier.height(64.dp)) }
    }
}
