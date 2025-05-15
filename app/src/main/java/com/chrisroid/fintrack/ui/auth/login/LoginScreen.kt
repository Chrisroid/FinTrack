package com.chrisroid.fintrack.ui.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Welcome back 🎉",
                style = appText.copy(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Sign in to your account and start\nmanaging your finances with Fintrack today.",
                style = appText.copy(fontSize = 16.sp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            TextInput(
                title = "Email address",
                placeholder = "e.g email@mail.com",
                code = email,
                onCodeChange = { email = it }
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            CustomButton(
                text = "Sign In",
                onClick = {
                    // Handle sign in logic
                    navController.navigate(Routes.LOGIN_OTP)
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Do not have an account? ", style = appText.copy(fontSize = 14.sp))
                Text(
                    "Sign Up",
                    style = appText.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF008080)
                    ),
                    modifier = Modifier.clickable {
                        navController.navigate(Routes.SIGNUP)
                    }
                )
            }
        }
    }
}
