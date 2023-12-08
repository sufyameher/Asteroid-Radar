package com.example.asteroidradar1.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import com.example.asteroidradar1.api.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
//@InstallIn(Application::class)
object ApiModule {

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideApiService(gson: Gson): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
    }
}

