package com.example.evbuddyapp.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.evbuddyapp.ui.common.composables.BasicButton
import com.example.evbuddyapp.ui.common.composables.BottomAppNavigation
import com.example.evbuddyapp.ui.common.composables.HeaderTopAppBar
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    onNearbyDriversClick: () -> Unit
) {

    Scaffold(
        topBar = {
            HeaderTopAppBar(
                value = "EV Buddy - Charge On Demand"
            )
        },
        bottomBar = {
            BottomAppNavigation(navController = navController)
        }
    ) { innerPadding ->
        HomeContent(
            modifier = Modifier.padding(innerPadding),
            onNearbyDriversClick = onNearbyDriversClick
        )
    }

}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onNearbyDriversClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val newYork = LatLng(40.7128, -74.0060)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(newYork, 15f)
        }

        var isMapLoaded by remember { mutableStateOf(false) }


        GoogleMap(
            modifier = Modifier
                .weight(1f)
                .padding(top = 32.dp),
            cameraPositionState = cameraPositionState,
            onMapLoaded = { isMapLoaded = true }
        )

        Row(
            modifier = Modifier
                .padding(top = 32.dp)
        ) {
            BasicButton(
                value = "Find Fixed Charger",
                onButtonClick = {}
            )
            Spacer(modifier.size(5.dp))
            BasicButton(
                value = "Find Mobile Power Driver",
                onButtonClick = {
                    onNearbyDriversClick()
                }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview(modifier: Modifier = Modifier) {
    HomeScreen(
        navController = rememberNavController(),
        onNearbyDriversClick = {}
    )
}