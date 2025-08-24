package com.example.evbuddyapp.data.repository

import com.example.evbuddyapp.data.model.DataApiResponse

interface DataRepository {

    suspend fun getDriversNearby(): DataApiResponse


}