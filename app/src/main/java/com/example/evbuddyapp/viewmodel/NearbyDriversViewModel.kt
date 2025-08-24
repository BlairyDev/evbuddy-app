package com.example.evbuddyapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evbuddyapp.data.model.DataApiResponse
import com.example.evbuddyapp.data.repository.DataRepository
import com.example.evbuddyapp.model.DataApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NearbyDriversViewModel @Inject constructor(
    private val dataRepository: DataRepository
): ViewModel() {

    private val _drivers = MutableStateFlow<NearbyDriversState>(NearbyDriversState.Loading)
    val driversState: StateFlow<NearbyDriversState> = _drivers.asStateFlow()


    init {
        fetchDrivers()
    }

    fun fetchDrivers() = viewModelScope.launch {
        when (val response = dataRepository.getDriversNearby()) {
            DataApiResponse.Error -> _drivers.value = NearbyDriversState.Failure
            is DataApiResponse.Success -> _drivers.value = NearbyDriversState.Success(response.drivers)
        }
    }



    sealed class NearbyDriversState {
        data class Success(val drivers: List<DataApi>): NearbyDriversState()
        data object Failure: NearbyDriversState()
        data object Loading: NearbyDriversState()
    }
}