package com.example.evbuddyapp.model

data class DataApi(
    val driverName: String,
    val profilePicture: String = "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png?20170328184010",
    val distance: Double,
    val estimatedArrival: Int,
    val ratings: Double
)
