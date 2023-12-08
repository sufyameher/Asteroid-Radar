package com.example.asteroidradar1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asteroidradar1.model.Asteroid
import com.example.asteroidradar1.repository.AsteroidRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: AsteroidRepository) : ViewModel() {
    private val _allAsteroids = MutableLiveData<List<Asteroid>>()
    val allAsteroids: LiveData<List<Asteroid>> get() = _allAsteroids

//    val hazardousAsteroids: LiveData<List<Asteroid>> = Transformations.map(allAsteroids) { asteroids ->
//        asteroids.filter { it.isPotentiallyHazardous }
//    }
//
//    val nonHazardousAsteroids: LiveData<List<Asteroid>> = Transformations.map(allAsteroids) { asteroids ->
//        asteroids.filter { !it.isPotentiallyHazardous }
//    }

    init {
        viewModelScope.launch {
            _allAsteroids.value = repository.getAsteroids("2023-01-01", "2023-12-31","http://api.nasa.gov/neo/rest/v1/feed?start_date=2023-12-10&end_date=2023-12-17&detailed=false&api_key=yyv5gUVuRv4wmYg9BvK7nAmlO7aJxLD8N2eyue6j" )
        }
    }
}
