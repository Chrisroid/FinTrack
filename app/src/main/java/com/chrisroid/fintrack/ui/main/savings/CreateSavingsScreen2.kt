package com.chrisroid.fintrack.ui.main.savings

import android.os.Build
import android.service.autofill.DateTransformation
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun CreateSavingsScreen2(onContinue: () -> Unit) {
    var targetDate by remember { mutableStateOf("") }
    var monthlyContribution by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Create Savings Goal - Step 2", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = targetDate,
            onValueChange = { targetDate = it },
            label = { Text("Target Date (MM/YYYY)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = monthlyContribution,
            onValueChange = { if (it.all { char -> char.isDigit() || char == '.' }) monthlyContribution = it },
            label = { Text("Monthly Contribution") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onContinue,
            modifier = Modifier.fillMaxWidth(),
            enabled = targetDate.isNotBlank() && monthlyContribution.isNotBlank()
        ) {
            Text("Continue")
        }
    }
}