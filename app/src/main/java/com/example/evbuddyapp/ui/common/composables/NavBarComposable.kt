package com.example.evbuddyapp.ui.common.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.evbuddyapp.R
import com.example.evbuddyapp.navigation.BottomNavItem
import com.example.evbuddyapp.navigation.EvBuddyScreen

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Home",
            icon = {
                Icon(Icons.Filled.Home, contentDescription = "home")
            },
            route = EvBuddyScreen.HomeScreen.name
        ),
        BottomNavItem(
            label = "My Requests",
            icon = {
                Icon(imageVector = Icons.Filled.DateRange, contentDescription = "My Request")
            },
            route = EvBuddyScreen.Request.name
        ),
        BottomNavItem(
            label = "Profile",
            icon = {
                Icon(Icons.Filled.Person, contentDescription = "profile")
            },
            route = EvBuddyScreen.Profile.name
        )
    )
}

@Composable
fun BottomAppNavigation(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth(),
        containerColor = Color(0xFF00BCA1)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        val currentRoute = navBackStackEntry?.destination?.route

        Constants.BottomNavItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = { item.icon() },
                label = { Text(text = item.label, color = Color.White)},

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    indicatorColor = Color(0xFF008C7B)
                )

            )
        }


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderTopAppBar(
    modifier: Modifier = Modifier,
    value: String
) {

    TopAppBar(
        title = {
            Text(value)
        },
        actions = {

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF00BCA1),
            titleContentColor = Color.White
        )

    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExitAppNavigation(
    modifier: Modifier = Modifier,
    title: String? = "",
    onExitClick: () -> Unit
) {

    TopAppBar(
        modifier = Modifier
            .drawBehind {
                val strokeWidth = 1.5.dp.toPx()
                drawLine(
                    color = Color(0xFFADB5BD).copy(alpha = 1f),
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = strokeWidth
                )
            },
        title = {
            Text(title.toString(), overflow = TextOverflow.Ellipsis, maxLines = 1)
        },
        navigationIcon = {
            IconButton(
                onClick = { onExitClick() }
            ) {
                Icon(painter = painterResource(R.drawable.outline_arrow_left_alt_24), contentDescription = "Exit button")

            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF00BCA1),
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        )
    )

}
