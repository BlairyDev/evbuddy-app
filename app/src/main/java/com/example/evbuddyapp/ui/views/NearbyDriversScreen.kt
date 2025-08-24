package com.example.evbuddyapp.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.evbuddyapp.model.DataApi
import com.example.evbuddyapp.ui.common.composables.ExitAppNavigation
import com.example.evbuddyapp.ui.common.composables.SimpleText
import com.example.evbuddyapp.ui.common.composables.StarRatingBar
import com.example.evbuddyapp.viewmodel.NearbyDriversViewModel

@Composable
fun NearbyDriversScreen(
    modifier: Modifier = Modifier,
    viewModel: NearbyDriversViewModel = hiltViewModel(),
    navController: NavController
) {

    val driversState by viewModel.driversState.collectAsState()

    Scaffold(
        topBar = {
            ExitAppNavigation(onExitClick = { navController.popBackStack() })
        }

    ) { innerPadding ->

        NearbyDriversContent(
            modifier = Modifier.padding(innerPadding),
            driversState = driversState
        )

    }


    
}

@Composable
fun NearbyDriversContent(
    modifier: Modifier = Modifier,
    driversState: NearbyDriversViewModel.NearbyDriversState
) {

    when (driversState) {
        is NearbyDriversViewModel.NearbyDriversState.Loading -> {

            Column(
                modifier = modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    color = Color(0xFF00BCA1)
                )
            }
        }
        is NearbyDriversViewModel.NearbyDriversState.Success -> {
            val drivers = driversState.drivers

            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                items(drivers) { driver ->

                    Card(
                        modifier = Modifier
                            .padding(3.dp)
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF00BCA1)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(CircleShape),
                                model = driver.profilePicture,
                                contentDescription = "user image"
                            )

                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                SimpleText(value = "Name: " + driver.driverName)
                                Spacer(modifier = Modifier.size(3.dp))
                                SimpleText(value = "Distance: " + driver.distance.toString() + " km")
                                Spacer(modifier = Modifier.size(3.dp))
                                SimpleText(value = "ETA: " + driver.estimatedArrival.toString() + " mins")
                                Row(
                                    modifier = Modifier.padding(top = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    StarRatingBar(
                                        rating = driver.ratings,
                                    )

                                    Spacer(modifier = Modifier.width(5.dp))

                                    SimpleText(value = driver.ratings.toString())

                                }
                            }

                        }


                    }

                    Spacer(modifier = Modifier.size(16.dp))
                }

            }

        }
        is NearbyDriversViewModel.NearbyDriversState.Failure -> {

        }
    }

}

@Preview(showBackground = true)
@Composable
fun NearbyDriversPreview(modifier: Modifier = Modifier) {
    val dataList = listOf(
        DataApi(driverName = "Alice Johnson", distance = 1.2, estimatedArrival = 5, ratings = 4.9),
        DataApi(driverName = "Brian Smith", distance = 0.8, estimatedArrival = 3, ratings = 4.7),
        DataApi(driverName = "Carla Reyes", distance = 2.5, estimatedArrival = 10, ratings = 4.5),
        DataApi(driverName = "David Kim", distance = 0.6, estimatedArrival = 2, ratings = 4.8),
        DataApi(driverName = "Ella Martinez", distance = 3.0, estimatedArrival = 12, ratings = 4.6)
    )

    val driversState = NearbyDriversViewModel.NearbyDriversState.Success(dataList)

    NearbyDriversContent(
        driversState = driversState
    )
    
}