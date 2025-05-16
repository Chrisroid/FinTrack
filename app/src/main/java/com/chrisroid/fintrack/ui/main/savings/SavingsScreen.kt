package com.chrisroid.fintrack.ui.main.savings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chrisroid.fintrack.R
import com.chrisroid.fintrack.ui.theme.appText

data class SavingsGoal(
    val name: String,
    val saved: Double,
    val goal: Double,
    val imageRes: Int
)

@Composable
fun SavingsScreen(onSavingsClick: (String) -> Unit = {}) {
    val savingsGoals = listOf(
        SavingsGoal("Trip to Kenya", 0.0, 500_000.0, R.drawable.kenya),
        SavingsGoal("House rent", 400_000.0, 500_000.0, R.drawable.house)
    )

    var showAmount by remember { mutableStateOf(true) }

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {

                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        "My Savings",
                        style = appText.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }


                Spacer(modifier = Modifier.height(16.dp))

                // Top Card
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFF952B)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.bg_savings),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.matchParentSize()
                        )

                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Total Savings", style = appText.copy(color = Color.White))

                            Spacer(modifier = Modifier.height(4.dp))

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    if (showAmount) "₦ 0.00" else "₦ ******",
                                    style = appText.copy(
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(
                                    Icons.Default.Visibility,
                                    contentDescription = "Toggle Visibility",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clickable { showAmount = !showAmount }
                                )
                            }

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                "You need ₦250,000 to meet your targets.",
                                style = appText.copy(color = Color.White, fontSize = 14.sp)
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(4.dp)
                                    .clip(RoundedCornerShape(2.dp))
                                    .background(Color.White.copy(alpha = 0.6f))
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text("Saving goals", style = appText.copy(fontWeight = FontWeight.SemiBold, fontSize = 16.sp))
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(savingsGoals) { goal ->
                SavingsGoalItem(goal, onClick = { onSavingsClick(goal.name) })
                Spacer(modifier = Modifier.height(12.dp))
            }

            item { Spacer(modifier = Modifier.height(100.dp)) }
        }

        FloatingActionButton(
            onClick = { /* TODO */ },
            containerColor = Color(0xFFFF952B),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }
}

@Composable
fun SavingsGoalItem(goal: SavingsGoal, onClick: () -> Unit) {
    val progress = (goal.saved / goal.goal).coerceIn(0.0, 1.0)
    val percentage = (progress * 100).toInt()

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.Transparent),
        border = BorderStroke(1.dp, Color.LightGray),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = goal.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(goal.name, style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 20.sp))
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("₦ ${"%,.0f".format(goal.saved)}\nSaved", style = appText.copy(fontSize = 12.sp))
                    Text("₦ ${"%,.0f".format(goal.goal)}\nTotal Goal", style = appText.copy(fontSize = 12.sp))
                }

                Spacer(modifier = Modifier.height(6.dp))

                LinearProgressIndicator(
                    progress = progress.toFloat(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = Color(0xFFFF952B),
                    trackColor = Color(0xFFFFE6CC)
                )

                if (progress > 0) {
                    Text(
                        "$percentage%",
                        style = appText.copy(fontSize = 10.sp, color = Color.Gray),
                        modifier = Modifier.align(Alignment.End)
                    )
                }
            }
        }
    }
}
