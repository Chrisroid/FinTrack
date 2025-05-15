package com.chrisroid.fintrack.ui.auth.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chrisroid.fintrack.navigation.Routes
import com.chrisroid.fintrack.ui.base.CustomButton
import com.chrisroid.fintrack.ui.base.TextInput
import com.chrisroid.fintrack.ui.theme.appText

@Composable
fun SignUpScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var referral by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Let’s get started! 🎉",
                style = appText.copy(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Join us and start managing your finances\nwith Fintrack today.",
                style = appText.copy(fontSize = 16.sp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text("First & Last Name", style = appText.copy(fontSize = 14.sp))
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                placeholder = { Text("e.g John Doe") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextInput(
                title = "Email address",
                placeholder = "e.g email@mail.com",
                code = email,
                onCodeChange = { email = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextInput(
                title = "Enter a referral code (optional)",
                placeholder = "e.g email@mail.com",
                code = referral,
                onCodeChange = { referral = it }
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            CustomButton(
                text = "Create an account",
                onClick = { navController.navigate(Routes.VERIFICATION) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Already have an account? ", style = appText.copy(fontSize = 14.sp))
                Text(
                    "Sign In",
                    style = appText.copy(
                        fontSize = 14.sp,
                        color = Color(0xFF008080),
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier.clickable {
                        navController.navigate(Routes.LOGIN)
                    }

                )
            }
        }
    }
}
