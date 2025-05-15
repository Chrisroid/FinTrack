package com.chrisroid.fintrack.ui.auth.accountsetup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chrisroid.fintrack.R
import com.chrisroid.fintrack.navigation.Routes
import com.chrisroid.fintrack.ui.base.CustomButton
import com.chrisroid.fintrack.ui.theme.appText

@Composable
fun AccountSetupScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = buildAnnotatedString {
                    append("Welcome to ")
                    withStyle(style = SpanStyle(color = Color(0xFF008080), fontWeight = FontWeight.Bold)) {
                        append("Fintrack")
                    }
                    append("!\nLet’s get you set up.")
                },
                style = appText.copy(fontSize = 22.sp, lineHeight = 30.sp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            SetupCard(
                title = "Set up a pin",
                subtitle = "Enhance your account security.",
                imageRes = R.drawable.onboarding_image4
            )

            Spacer(modifier = Modifier.height(16.dp))

            SetupCard(
                title = "Link your bank accounts.",
                subtitle = "Link your bank accounts to start tracking your expenses.",
                imageRes = R.drawable.onboarding_image1
            )

            Spacer(modifier = Modifier.height(16.dp))

            SetupCard(
                title = "Create a savings goal",
                subtitle = "What are your financial goals?",
                imageRes = R.drawable.onboarding_image3
            )
        }

        CustomButton(
            text = "Skip for now",
            onClick = {  navController.navigate(Routes.CREATE_PIN) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun SetupCard(title: String, subtitle: String, imageRes: Int) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, style = appText.copy(fontSize = 16.sp, fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = subtitle, style = appText.copy(fontSize = 14.sp))
            }

            Spacer(modifier = Modifier.width(12.dp))

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
        }
    }
}
