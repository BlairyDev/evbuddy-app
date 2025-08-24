package com.example.evbuddyapp.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evbuddyapp.ui.common.composables.BottomAppNavigation
import com.example.evbuddyapp.ui.views.HomeScreen
import com.example.evbuddyapp.ui.views.NearbyDriversScreen
import com.example.evbuddyapp.ui.views.ProfileScreen
import com.example.evbuddyapp.ui.views.RequestScreen

enum class EvBuddyScreen() {
    HomeScreen,
    Profile,
    Request,
    NearbyDrivers
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EvBuddyNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = EvBuddyScreen.HomeScreen.name
    ) {
        composable(
            route = EvBuddyScreen.HomeScreen.name,
            enterTransition = { EnterTransition.None }
        ) {
            HomeScreen(
                modifier = modifier,
                navController = navController,
                onNearbyDriversClick = { navController.navigate(EvBuddyScreen.NearbyDrivers.name) }
            )
        }

        composable(
            route = EvBuddyScreen.Request.name,
            enterTransition = { EnterTransition.None }
        ) {
            RequestScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            route = EvBuddyScreen.Profile.name,
            enterTransition = { EnterTransition.None }
        ) {
            ProfileScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            route = EvBuddyScreen.NearbyDrivers.name,
            enterTransition = { EnterTransition.None }
        ) {
            NearbyDriversScreen(
                modifier = modifier,
                navController = navController
            )
        }

    }




}