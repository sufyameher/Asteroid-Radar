package com.example.asteroidradar1.di

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.hilt.InstallIn

//@InstallIn(ApplicationComponent::class)
@Component(modules = [ApiModule::class])
interface MyComponent {

}