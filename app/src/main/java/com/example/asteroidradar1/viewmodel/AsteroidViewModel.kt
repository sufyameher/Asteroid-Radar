package com.example.asteroidradar1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.asteroidradar1.model.Asteroid
import com.example.asteroidradar1.repository.AsteroidRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AsteroidViewModel @Inject constructor(application: Application,
    private val repository: AsteroidRepository
) : AndroidViewModel(application) {

    private val _asteroids = MutableLiveData<List<Asteroid>>()
    val asteroids: LiveData<List<Asteroid>> get() = _asteroids

    fun fetchAsteroids(startDate: String, endDate: String) {
        viewModelScope.launch {
            try {
                val response = repository.getAsteroids(startDate, endDate, "https://api.nasa.gov/neo/rest/v1/feed?start_date=2022-10-22&end_date=2022-10-26&api_key=yyv5gUVuRv4wmYg9BvK7nAmlO7aJxLD8N2eyue6j")
                println("API Response: $response")
               // _asteroids.value = response.asteroids
            } catch (e: Exception) {
                println("API Request Failed: $e")
                // Handle the exception (e.g., show an error message)
            }
        }
    }
}
