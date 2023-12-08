package com.example.asteroidradar1.repository

import com.example.asteroidradar1.api.ApiService
import com.example.asteroidradar1.model.Asteroid
import javax.inject.Inject

class AsteroidRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getAsteroids(startDate: String, endDate: String, apiKey: String): List<Asteroid> {
        return apiService.getAsteroids(startDate, endDate, apiKey).asteroids
    }
}
