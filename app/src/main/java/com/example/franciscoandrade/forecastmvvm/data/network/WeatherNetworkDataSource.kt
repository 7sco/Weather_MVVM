package com.example.franciscoandrade.forecastmvvm.data.network

import androidx.lifecycle.LiveData
import com.example.franciscoandrade.forecastmvvm.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
}