package com.example.evbuddyapp.ui.common.composables

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun BasicButton(
    modifier: Modifier = Modifier,
    value: String,
    onButtonClick: () -> Unit
) {
    Button(
        onClick = {
            onButtonClick()
        },
        colors = ButtonDefaults.buttonColors(Color(0xFF00BCA1))
    ) {
        Text(value, fontSize = 12.sp)
    }
}