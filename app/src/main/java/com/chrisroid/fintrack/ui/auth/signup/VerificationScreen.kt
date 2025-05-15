package com.chrisroid.fintrack.ui.auth.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chrisroid.fintrack.navigation.Routes
import com.chrisroid.fintrack.ui.base.CustomButton
import com.chrisroid.fintrack.ui.base.TextInput
import com.chrisroid.fintrack.ui.theme.appText

@Composable
fun VerificationScreen(navController: NavController) {
    var code by remember { mutableStateOf("") }

    var remainingSeconds by remember { mutableStateOf(50) }

    LaunchedEffect(Unit) {
        while (remainingSeconds > 0) {
            kotlinx.coroutines.delay(1000L)
            remainingSeconds--
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Check your email!",
                style = appText.copy(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "We have sent an email to\njanedoe@gmail.com. Please remember to check your inbox as well as the spam folder.",
                style = appText.copy(fontSize = 16.sp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Please enter the verification code below to continue with your account.",
                style = appText.copy(fontSize = 16.sp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            TextInput(
                title = "Enter verification code",
                placeholder = "Enter code here",
                code = code,
                onCodeChange = { code = it }
            )

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            CustomButton(
                text = "Continue",
                onClick = {
                    // Replace with actual logic
                    navController.navigate(Routes.ACCOUNT_SETUP)
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Didn’t receive the email? ",
                    style = appText.copy(fontSize = 14.sp, color = Color.Gray)
                )
                Text(
                    text = if (remainingSeconds > 0)
                        "Resend code in ${remainingSeconds}s"
                    else
                        "Resend Code",
                    style = appText.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF008080)
                    ),
                    modifier = Modifier.clickable(enabled = remainingSeconds == 0) {
                        // TODO: Handle resend action here
                        remainingSeconds = 50
                    }
                )
            }
        }
    }
}
