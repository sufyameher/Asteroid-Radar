package com.example.asteroidradar1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asteroidradar1.api.ApiService
import com.example.asteroidradar1.model.PictureOfTheDay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// ApodViewModel.kt
@HiltViewModel
class PictureOfTheDayViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {
    private val _pictureOfTheDay = MutableLiveData<PictureOfTheDay>()
    val pictureOfTheDay: LiveData<PictureOfTheDay> get() = _pictureOfTheDay

    fun fetchPictureOfTheDay() {
        viewModelScope.launch {
            try {
                val response = apiService.getPictureOfTheDay("https://api.nasa.gov/neo/rest/v1/feed?api_key=yyv5gUVuRv4wmYg9BvK7nAmlO7aJxLD8N2eyue6j")
                _pictureOfTheDay.value = response
            } catch (e: Exception) {
                // Handle the exception (e.g., show an error message)
            }
        }
    }
}
