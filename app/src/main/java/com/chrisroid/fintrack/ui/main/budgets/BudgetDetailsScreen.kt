package com.chrisroid.fintrack.ui.main.budgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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

@Composable
fun BudgetDetailsScreen() {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        // Header
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
                text = "Trip to Nairobi",
                style = appText.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.weight(1f)) // balances the row
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Budget Summary Card
        BudgetCard(
            BudgetItem(
                title = "Trip to Nairobi",
                dateRange = "7/16/2024 to 8/16/2024",
                spent = "₦ 300,000.80",
                total = "₦ 350,500.00",
                remaining = "₦ 50,500.00",
                isDefault = true
            ),
            onClick = {},
            showEasy = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        Spacer(modifier = Modifier.height(12.dp))

        // Budget Sources
        SectionHeader("Budget source", onClick = {})
        Spacer(modifier = Modifier.height(8.dp))
        BankItem("Kuda Bank", "₦2,987.56")
        BankItem("Kuda Bank", "₦2,987.56")

        Spacer(modifier = Modifier.height(24.dp))

        // Latest Transactions
        SectionHeader("Latest Transactions", onClick = {})
        Spacer(modifier = Modifier.height(8.dp))
        TransactionItem("Do Bowls Hospitality", "Zenith Bank 12:03 AM", "₦10,000.00", "J")
        TransactionItem("Paystack Checkout", "Kuda Bank 12:03 AM", "₦6,000.00", "J")

        Spacer(modifier = Modifier.height(24.dp))

        // Edit Button
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF007D82)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Text("Edit Budget", color = Color.White)
        }
    }
}

@Composable
fun SectionHeader(title: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, style = appText.copy(fontSize = 16.sp, fontWeight = FontWeight.Bold))
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .clickable { onClick() }
                .background(Color(0xFFD1EFEE))
                .padding(horizontal = 10.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("View All", style = appText.copy(fontSize = 14.sp, color = Color(0xFF007D82)))
            Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Color(0xFF007D82))
        }
    }
}

@Composable
fun BankItem(bankName: String, balance: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            shape = CircleShape,
            color = Color(0xFFD1EFEE),
            modifier = Modifier.size(40.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text("K", color = Color.White, fontSize = 18.sp)
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(bankName, style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 20.sp))
            Text("Account balance: $balance", style = appText.copy(color = Color.Gray, fontSize = 14.sp))
        }
    }
}

@Composable
fun TransactionItem(title: String, subtitle: String, amount: String, initial: String) {
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
                color = Color(0xFFD1EFEE),
                modifier = Modifier.size(40.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(initial, color = Color.Black, fontSize = 16.sp)
                }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(title, style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 14.sp))
                Text(subtitle, style = appText.copy(color = Color.Gray, fontSize = 12.sp))
            }
        }
        Text(amount, style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 14.sp))
    }
}
