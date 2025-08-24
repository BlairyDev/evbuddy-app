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
fun RequestScreen(
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
        RequestContent(modifier = Modifier.padding(innerPadding))
    }

}


@Composable
fun RequestContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text("My Request")
    }
}

@Preview(showBackground = true)
@Composable
fun RequestPreview(modifier: Modifier = Modifier) {

}