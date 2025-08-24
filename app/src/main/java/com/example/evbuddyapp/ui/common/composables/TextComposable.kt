package com.example.evbuddyapp.ui.common.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SimpleText(
    modifier: Modifier = Modifier,
    value: String
) {
    Text(text = value, color = Color.White)
}