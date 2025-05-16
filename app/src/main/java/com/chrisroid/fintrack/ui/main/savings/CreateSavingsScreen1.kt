package com.chrisroid.fintrack.ui.main.savings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import com.chrisroid.fintrack.R
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.chrisroid.fintrack.ui.theme.appText

@Composable
fun CreateSavingsScreen1() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

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
                text = "Trip to Kenya",
                style = appText.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.weight(1f)) // balances the row
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Savings Card
        Card(
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color.LightGray),
            colors = CardDefaults.cardColors(Color.Transparent),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.kenya),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text("Trip to Kenya", style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 16.sp))
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("₦ 0", style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 16.sp))
                            Text("Saved", style = appText.copy(fontSize = 12.sp, color = Color.Gray))
                        }
                        Column(horizontalAlignment = Alignment.End) {
                            Text("₦ 500,000.00", style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 16.sp))
                            Text("Total Goal", style = appText.copy(fontSize = 12.sp, color = Color.Gray))
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    LinearProgressIndicator(
                        progress = 0f,
                        color = Color(0xFFFF952B),
                        trackColor = Color(0xFFFFE6CC),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(5.dp)
                            .clip(RoundedCornerShape(4.dp))
                    )
                    Text("0%", style = appText.copy(fontSize = 10.sp, color = Color.Gray), modifier = Modifier.align(Alignment.End))
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Fund source
        LabeledSection("Fund source", "Kuda Bank", "₦ 250,000", "Account balance: ₦2,987.56")

        // Goal duration
        LabeledSection("Goal duration", "16/07/2024", "26/07/2024", "Start date", "End date")

        // More details
        LabeledSection("More details", "Daily", "25 days", "Frequency", "Days left")

        // Recent Activities
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Recent Activities", style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 14.sp))
                Text("View All", color = Color(0xFFFF952B), fontSize = 14.sp, modifier = Modifier.clickable { })
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text("Today, 14/07/2024", style = appText.copy(color = Color.Gray, fontSize = 12.sp))
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                "Created a new budget “Trip to Kenya” ₦200,000.00",
                style = appText.copy(fontSize = 14.sp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Edit Button
        Button(
            onClick = { /* Edit goal action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF952B)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text("Edit Goal", color = Color.White)
        }
    }
}

@Composable
fun LabeledSection(
    label: String,
    startValue: String,
    endValue: String,
    startHint: String = "",
    endHint: String = ""
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label, style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 14.sp))
            Surface(
                shape = RoundedCornerShape(50),
                color = Color(0xFFFFE6CC),
                modifier = Modifier.clickable {  }
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Change", style = appText.copy(color = Color(0xFFFF8000), fontSize = 14.sp))
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(startValue, style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 14.sp))
                if (startHint.isNotBlank()) {
                    Text(startHint, style = appText.copy(fontSize = 12.sp, color = Color.Gray))
                }
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(endValue, style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 14.sp))
                if (endHint.isNotBlank()) {
                    Text(endHint, style = appText.copy(fontSize = 12.sp, color = Color.Gray))
                }
            }
        }
    }
}