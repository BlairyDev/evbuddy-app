package com.example.evbuddyapp.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.evbuddyapp.ui.common.composables.BottomAppNavigation
import com.example.evbuddyapp.ui.common.composables.HeaderTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = {
            HeaderTopAppBar(
                value = ""
            )
        },
        bottomBar = {
            BottomAppNavigation(navController = navController)
        }
    ) { innerPadding ->

        ProfileContent(modifier = Modifier.padding(innerPadding))

    }

}

@Composable
fun ProfileContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text("Profile")
    }

}


@Preview(showBackground = true)
@Composable
fun ProfilePreview(modifier: Modifier = Modifier) {

}