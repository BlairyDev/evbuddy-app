package com.example.evbuddyapp.data.model

import com.example.evbuddyapp.model.DataApi

sealed class DataApiResponse {
    data class Success(val drivers: List<DataApi>): DataApiResponse()
    data object Error: DataApiResponse()
}