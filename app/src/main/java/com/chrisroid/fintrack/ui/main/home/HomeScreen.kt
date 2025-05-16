package com.chrisroid.fintrack.ui.main.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import com.chrisroid.fintrack.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chrisroid.fintrack.navigation.Routes
import com.chrisroid.fintrack.ui.theme.appText
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun HomeScreen() {
    val cards = listOf(
        AccountCardData(
            "Account balance",
            "₦ 1,000,500.55",
            "The total balance from your linked accounts.",
            R.drawable.bg_account
        ),
        AccountCardData(
            "Total savings",
            "₦ 50,530.00",
            "You need ₦250,000 to meet your targets.",
            R.drawable.bg_savings
        ),
        AccountCardData(
            "Monthly budget",
            "₦ 1,000,500.55",
            "left out of ₦200,000,000 budgeted.",
            R.drawable.bg_budget
        ),
        AccountCardData(
            "Total expenses",
            "₦ 1,000,500.55",
            "spent in the last 7 days",
            R.drawable.bg_expense
        )
    )

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    "Hello, Jane",
                    style = appText.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF161B26))
                )
                Text(
                    "Your financial journey starts here.",
                    style = appText.copy(fontSize = 14.sp, color = Color(0xFF161B26))
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Surface(
                    shape = CircleShape,
                    color = Color(0xFFFFEDD9),
                    modifier = Modifier.size(40.dp)
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Profile",
                            tint = Color(0xFF161B26),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                Surface(
                    shape = CircleShape,
                    color = Color(0xFFFFEDD9),
                    modifier = Modifier.size(40.dp)
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications",
                            tint = Color(0xFF161B26),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        val pagerState = rememberPagerState()

        LaunchedEffect(pagerState) {
            while (true) {
                delay(2500)
                val nextPage = (pagerState.currentPage + 1) % cards.size
                pagerState.animateScrollToPage(nextPage)
            }
        }

        HorizontalPager(count = cards.size, state = pagerState) { page ->
            SwipableCard(cards[page])
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(cards.size) { index ->
                Box(
                    modifier = Modifier
                        .height(4.dp)
                        .width(10.dp)
                        .background(
                            if (index == pagerState.currentPage) Color(0xFF008080) else Color(0xFFCCE6E6),
                            shape = CircleShape
                        )
                )
                if (index != cards.lastIndex) Spacer(modifier = Modifier.width(8.dp))
            }
        }


        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color.LightGray),
            modifier = Modifier
                .fillMaxWidth()
                .clickable { },
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row {
                        Text("Your ", style = appText.copy(fontSize = 22.sp))
                        Text(
                            "Week",
                            style = appText.copy(fontSize = 24.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                    Row {
                        Text("in ", style = appText.copy(fontSize = 22.sp))
                        Text(
                            "Money",
                            style = appText.copy(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFF952B)
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "See your past week in money",
                        style = appText.copy(color = Color.Gray, fontSize = 14.sp)
                    )
                }

                Surface(
                    shape = CircleShape,
                    color = Color(0xFFD1EFEE),
                    modifier = Modifier.size(40.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "Next",
                            tint = Color(0xFF007D82)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color.LightGray),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Recent Activities",
                        style = appText.copy(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    )
                    Surface(
                        shape = RoundedCornerShape(50),
                        color = Color(0xFFD1EFEE),
                        modifier = Modifier.clickable {  }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("View All", style = appText.copy(color = Color(0xFF007D82), fontSize = 14.sp))
                            Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Color(0xFF007D82))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text("Today, 14/07/2024", style = appText.copy(color = Color.Gray, fontSize = 14.sp))
                Spacer(modifier = Modifier.height(8.dp))

                ActivityRow(
                    iconEmoji = "C",
                    title = "Created a new budget\nTrip to Nairobi",
                    amount = "₦200,000.00",
                    subtitle = "a day ago",
                    iconBgColor = Color(0xFFFFE6CC),
                    iconTint = Color(0xFF2B9D9B)
                )
                ActivityRow(
                    iconEmoji = "J",
                    title = "John Ogaga",
                    amount = "₦10,000.00",
                    subtitle = "Zenith Bank 12:03 AM",
                    iconBgColor = Color(0xFFD1EFEE),
                    iconTint = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text("Yesterday, 13/07/2024", style = appText.copy(color = Color.Gray, fontSize = 14.sp))
                Spacer(modifier = Modifier.height(8.dp))

                ActivityRow(
                    iconEmoji = "C",
                    title = "Created a new budget\n“Trip to Nairobi”",
                    amount = "₦200,000.00",
                    subtitle = "a day ago",
                    iconBgColor = Color(0xFFFFE6CC),
                    iconTint = Color(0xFF2B9D9B)
                )
            }
        }
    }
}

@Composable
fun SwipableCard(data: AccountCardData) {
    val useBlackText = data.title.contains("budget", ignoreCase = true) ||
            data.title.contains("expenses", ignoreCase = true)
    val textColor = if (useBlackText) Color.Black else Color.White

    var showAmount by remember { mutableStateOf(true) }

    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(horizontal = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box (modifier = Modifier.clip(RoundedCornerShape(20.dp))){
            Image(
                painter = painterResource(id = data.background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(data.title, style = appText.copy(fontSize = 16.sp, color = textColor))
                    Surface(
                        color = if (useBlackText) Color(0xFF007D82) else Color.White,
                        shape = RoundedCornerShape(50)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val buttonLabel = when {
                                data.title.contains("Account", ignoreCase = true) -> "Manage Accounts"
                                data.title.contains("Savings", ignoreCase = true) -> "View Savings"
                                data.title.contains("Budget", ignoreCase = true) -> "Manage Budget"
                                else -> "View expenses"
                            }
                            Text(buttonLabel, style = appText.copy(color = if (useBlackText) Color.White else Color(0xFF007D82), fontSize = 12.sp))
                            Icon(Icons.Default.ChevronRight, contentDescription = null, tint = if (useBlackText) Color.White else Color(0xFF007D82), modifier = Modifier.size(16.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        if (showAmount) data.amount else "₦ ******",
                        style = appText.copy(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = textColor)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.Visibility,
                        contentDescription = "Toggle Visibility",
                        tint = textColor,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { showAmount = !showAmount }
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(data.subtitle, style = appText.copy(fontSize = 14.sp, color = textColor))

                if (!data.title.contains("Account", ignoreCase = true)) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                            .background(
                                if (useBlackText) Color(0xFFFF952B) else Color.White.copy(alpha = 0.7f),
                                shape = RoundedCornerShape(2.dp)
                            )
                    )
                }
            }
        }
    }
}




@Composable
fun ActivityRow(
    iconEmoji: String,
    title: String,
    amount: String,
    subtitle: String,
    iconBgColor: Color,
    iconTint: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
                shape = CircleShape,
                color = iconBgColor,
                modifier = Modifier.size(40.dp)
            ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text(iconEmoji, color = iconTint, fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(title, style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 14.sp))
                Text(subtitle, style = appText.copy(color = Color.Gray, fontSize = 12.sp))
            }
        }

        Text(amount, style = appText.copy(fontSize = 14.sp, fontWeight = FontWeight.Bold))
    }
}

data class AccountCardData(
    val title: String,
    val amount: String,
    val subtitle: String,
    val background: Int
)
