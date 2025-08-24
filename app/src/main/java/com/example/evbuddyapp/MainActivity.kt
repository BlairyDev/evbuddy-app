package com.example.evbuddyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.evbuddyapp.navigation.EvBuddyNavigation
import com.example.evbuddyapp.ui.theme.EvBuddyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EvBuddyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EvBuddyNavigation(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

