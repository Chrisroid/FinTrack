package com.chrisroid.fintrack.ui.auth.accesscode

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chrisroid.fintrack.navigation.Routes
import com.chrisroid.fintrack.ui.base.CustomButton
import com.chrisroid.fintrack.ui.theme.appText

@Composable
fun AccessCodeScreen(navController: NavController) {
    var code by remember { mutableStateOf("") }

    val maxLength = 4
    val digits = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "Sign out", "0", "⌫")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Welcome Back", style = appText.copy(fontSize = 22.sp))
            Spacer(modifier = Modifier.height(20.dp))
            Text("Jane Doe", style = appText.copy(fontSize = 18.sp, color = Color.Black))
            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                repeat(maxLength) { index ->
                    val char = code.getOrNull(index)?.toString() ?: ""
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .border(
                                BorderStroke(1.dp, Color.LightGray),
                                shape = RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = char,
                            style = appText.copy(fontSize = 24.sp, color = Color.Gray)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Column {
                digits.chunked(3).forEach { row ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)
                    ) {
                        row.forEach { item ->
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(horizontal = 8.dp)
                                    .aspectRatio(1f)
                                    .clickable {
                                        when (item) {
                                            "Sign out" -> {
                                                navController.navigate(Routes.LOGIN) {
                                                    popUpTo(Routes.ACCESS_CODE) { inclusive = true }
                                                }
                                            }
                                            "⌫" -> {
                                                if (code.isNotEmpty()) {
                                                    code = code.dropLast(1)
                                                }
                                            }
                                            else -> {
                                                if (code.length < maxLength) {
                                                    code += item
                                                }
                                            }
                                        }
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = item,
                                    style = appText.copy(
                                        fontSize = 20.sp,
                                        color = if (item == "Sign out") Color(0xFF008080) else Color.Black
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(
                text = "Continue",
                onClick = { navController.navigate(Routes.ACCOUNT_SETUP) },
                modifier = Modifier.fillMaxWidth(),
                enabled = code.length == maxLength
            )
        }
    }
}
