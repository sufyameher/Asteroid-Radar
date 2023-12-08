package com.example.asteroidradar1.api

import com.example.asteroidradar1.model.PictureOfTheDay
import com.example.asteroidradar1.model.AsteroidResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("neo/rest/v1/feed")
    suspend fun getAsteroids(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String
    ): AsteroidResponse

    @GET("planetary/apod")
    suspend fun getPictureOfTheDay(
        @Query("api_key") apiKey: String
    ): PictureOfTheDay
}
