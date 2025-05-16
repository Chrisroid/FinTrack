package com.chrisroid.fintrack.ui.main.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Divider
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
fun AccountScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "My Account",
            style = appText.copy(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Profile Card
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2B9D9B)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Aderinsola Adejuwon", style = appText.copy(fontSize = 20.sp, color = Color.White))
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("janedoe@gmail.com", style = appText.copy(color = Color.White, fontSize = 14.sp))
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("+234 90 1619 2553", style = appText.copy(color = Color.White, fontSize = 14.sp))
                }
                Icon(
                    painter = painterResource(R.drawable.edit),
                    contentDescription = "Edit",
                    tint = Color(0xFFFF952B),
                    modifier = Modifier
                        .size(30.dp)
                        .background(Color.White, shape = CircleShape)
                        .padding(6.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Settings Items
        SettingsItem(icon = R.drawable.security, title = "Security", subtitle = "Enable or disable biometrics")
        SettingsItem(icon = R.drawable.driving, title = "Insights and Reports", subtitle = "A detailed summary of how you have\nmanaged your money")
        SettingsItem(icon = R.drawable.support, title = "Support", subtitle = "We can assist you if you have any\nqueries")
        SettingsItem(icon = R.drawable.feedback, title = "Give feedback", subtitle = "Helps us better the experience for\nyou.")

        Spacer(modifier = Modifier.height(16.dp))

        TextItem("Log Out", isLogout = true)
        TextItem("About fintrack")
        TextItem("Privacy & Terms of Service")
        TextItem("Request account deletion")

        Spacer(modifier = Modifier.height(16.dp))

        // Contact Info
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.card_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
            )
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Contact info", style = appText.copy(color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold))
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(painterResource(id = R.drawable.mail), contentDescription = null, tint = Color.White)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("contact@fintrack.com", color = Color.White, style = appText.copy(fontSize = 14.sp))
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(painterResource(id = R.drawable.phone), contentDescription = null, tint = Color.White)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("+234 90 161 92553", color = Color.White, style = appText.copy(fontSize = 14.sp))
                    }
                }
            }
        }


        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "V1.0.0",
            style = appText.copy(color = Color.Gray, fontSize = 12.sp),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

    }
}

@Composable
fun SettingsItem(icon: Int, title: String, subtitle: String) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFECECED),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = Color(0xFFCCE8E6),
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(title, style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 18.sp))
                    Spacer(modifier = Modifier.height(9.dp))
                    Text(subtitle, style = appText.copy(fontSize = 14.sp, color = Color.Gray))
                }

            }
            Spacer(modifier = Modifier.width(12.dp))
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
fun TextItem(text: String, isLogout: Boolean = false) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFECECED),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = appText.copy(
                    fontSize = 16.sp,
                    color = if (isLogout) Color.Red else Color.Black
                )
            )

            if (!isLogout) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_right),
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}


