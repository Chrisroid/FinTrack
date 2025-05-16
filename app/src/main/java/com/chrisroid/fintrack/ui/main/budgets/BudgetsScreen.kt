package com.chrisroid.fintrack.ui.main.budgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.chrisroid.fintrack.R
import com.chrisroid.fintrack.ui.theme.appText

@Composable
fun BudgetsScreen() {
    val budgets = listOf(
        BudgetItem(
            title = "Monthly budget",
            dateRange = "7/16/2024 to 8/16/2024",
            spent = "₦ 300,000.80",
            total = "₦ 350,500.00",
            remaining = "₦ 50,500.00",
            isDefault = true
        ),
        BudgetItem(
            title = "Weekly budget",
            dateRange = "Jan 25th to Feb 25th",
            spent = "₦ 300,000.80",
            total = "₦ 350,500.00",
            remaining = "₦ 50,500.00",
            isDefault = false
        ),
        BudgetItem(
            title = "Christmas holiday",
            dateRange = "Jan 25th to Feb 25th",
            spent = "₦ 300,000.80",
            total = "₦ 350,500.00",
            remaining = "₦ 50,500.00",
            isDefault = false
        )
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ) {
        Text("My Budgets", style = appText.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold), modifier = Modifier.align(alignment = Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(12.dp))

        budgets.forEachIndexed { index, budget ->
            BudgetCard(budget)
            if (index == 0) {
                Spacer(modifier = Modifier.height(16.dp))
                Text("Other budgets", style = appText.copy(fontSize = 20.sp, fontWeight = FontWeight.SemiBold))
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Spacer(modifier = Modifier.height(80.dp))
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = { /* TODO */ },
            containerColor = Color(0xFF007D82)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }
}

@Composable
fun BudgetCard(budget: BudgetItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
    ) {
        Box (modifier = Modifier.clip(RoundedCornerShape(20.dp))){
            // Optional background image on bottom right
            Image(
                painter = painterResource(id = R.drawable.bg_budget),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

            Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 32.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(budget.title, style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 18.sp))
                    Spacer(modifier = Modifier.weight(1f))
                    if (budget.isDefault) {
                        Surface(
                            shape = RoundedCornerShape(50),
                            color = Color(0xFFD1EFEE)
                        ) {
                            Text(
                                "Default",
                                style = appText.copy(color = Color(0xFF007D82), fontSize = 12.sp),
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }
                    } else {
                        Surface(
                            shape = RoundedCornerShape(50),
                            color = Color(0xFF007D82)
                        ) {
                            Text(
                                "Set as Default",
                                style = appText.copy(color = Color.White, fontSize = 12.sp),
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))
                Text(budget.dateRange, style = appText.copy(color = Color.Gray, fontSize = 14.sp))

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold)) {
                            append(budget.remaining)
                        }
                        append(" left to spend")
                    },
                    style = appText.copy(fontSize = 16.sp)
                )

                Spacer(modifier = Modifier.height(12.dp))
                LinearProgressIndicator(
                    progress = 0.85f,
                    color = Color(0xFFFF952B),
                    trackColor = Color(0xFFFFE6CC),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .clip(RoundedCornerShape(4.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Amount Spent", style = appText.copy(fontSize = 16.sp, color = Color.Gray))
                        Text(budget.spent, style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 20.sp))
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Total Budget", style = appText.copy(fontSize = 16.sp, color = Color.Gray))
                        Text(budget.total, style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 20.sp))
                    }
                }
            }
        }
    }
}


@Composable
fun Badge(text: String, bgColor: Color = Color(0xFFD1EFEE), textColor: Color = Color(0xFF007D82)) {
    Surface(
        shape = RoundedCornerShape(50),
        color = bgColor
    ) {
        Text(
            text,
            style = appText.copy(color = textColor, fontSize = 12.sp),
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        )
    }
}

data class BudgetItem(
    val title: String,
    val dateRange: String,
    val spent: String,
    val total: String,
    val remaining: String,
    val isDefault: Boolean
)
