package com.chrisroid.fintrack.ui.auth.createpin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chrisroid.fintrack.ui.base.CustomButton
import com.chrisroid.fintrack.ui.theme.appText
import kotlinx.coroutines.delay

@Composable
fun CreatePinScreen(onComplete: () -> Unit) {
    var pin by remember { mutableStateOf("") }

    val keypadButtons = listOf(
        "1", "2", "3",
        "4", "5", "6",
        "7", "8", "9",
        ".", "0", "⌫"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Back Arrow
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back"
                )

                Spacer(modifier = Modifier.width(24.dp))

                Text(
                    text = "Create your passcode",
                    style = appText.copy(fontSize = 22.sp)
                )
            }



            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "For a more secure and convenient way to view your account, create a 4-digit passcode now.",
                style = appText.copy(fontSize = 16.sp),
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // PIN Circles
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                repeat(4) { index ->
                    val digit = pin.getOrNull(index)?.toString() ?: ""
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
                            text = digit,
                            style = appText.copy(fontSize = 24.sp, color = Color.Gray)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Keypad
            Column {
                keypadButtons.chunked(3).forEach { row ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {
                        row.forEach { key ->
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(horizontal = 8.dp)
                                    .aspectRatio(1f)
                                    .clickable {
                                        when (key) {
                                            "⌫" -> if (pin.isNotEmpty()) pin = pin.dropLast(1)
                                            "." -> Unit // do nothing
                                            else -> if (pin.length < 4) pin += key
                                        }
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = key,
                                    style = appText.copy(fontSize = 20.sp)
                                )
                            }
                        }
                    }
                }
            }
        }

        // Continue button
        CustomButton(
            text = "Create a Pin",
            onClick = { onComplete() },
            enabled = pin.length == 4,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
