package com.example.evbuddyapp.data.repository

import com.example.evbuddyapp.data.model.DataApiResponse
import com.example.evbuddyapp.model.DataApi
import kotlinx.coroutines.delay
import javax.inject.Inject

val dataList = listOf(
    DataApi(driverName = "Alice Johnson", distance = 1.2, estimatedArrival = 5, ratings = 4.9),
    DataApi(driverName = "Brian Smith", distance = 0.8, estimatedArrival = 3, ratings = 4.7),
    DataApi(driverName = "Carla Reyes", distance = 2.5, estimatedArrival = 10, ratings = 4.5),
    DataApi(driverName = "David Kim", distance = 0.6, estimatedArrival = 2, ratings = 4.8),
    DataApi(driverName = "Ella Martinez", distance = 3.0, estimatedArrival = 12, ratings = 4.6)
)
class DataRepositoryFake @Inject constructor() : DataRepository {
    override suspend fun getDriversNearby(): DataApiResponse {
        val result = dataList
        delay(1000)
        return if (result.isNotEmpty()) {
            DataApiResponse.Success(result)
        } else {
            DataApiResponse.Error
        }

    }
}