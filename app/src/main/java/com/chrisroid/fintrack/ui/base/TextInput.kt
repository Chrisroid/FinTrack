package com.chrisroid.fintrack.ui.base

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chrisroid.fintrack.ui.theme.appText

@Composable
fun TextInput(
    title: String,
    placeholder: String,
    code: String,
    onCodeChange: (String) -> Unit
) {
    Column {
        Text(
            text = title,
            style = appText.copy(fontSize = 14.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = code,
            onValueChange = onCodeChange,
            placeholder = {
                Text(
                    text = placeholder,
                    style = appText.copy(color = androidx.compose.ui.graphics.Color.Gray, fontSize = 14.sp)
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
