package com.chrisroid.fintrack.ui.base

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chrisroid.fintrack.R

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier.padding(horizontal = 24.dp),
    backgroundColor: Color = Color(0xFF008080),
    contentColor: Color = Color.White,
    height: Dp = 45.dp,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(height),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
            disabledContainerColor = Color.LightGray, // optional
            disabledContentColor = Color.DarkGray     // optional
        )
    ) {
        Text(
            text = text,
            color = Color(0xFFFAFAFA),
            fontFamily = FontFamily(Font(R.font.capriola)),
            fontSize = 16.sp
        )
    }
}

