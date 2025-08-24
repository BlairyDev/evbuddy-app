package com.example.evbuddyapp.navigation

import androidx.compose.runtime.Composable

data class BottomNavItem(
    val label: String,
    val icon: @Composable () -> Unit,
    val route: String,
)
