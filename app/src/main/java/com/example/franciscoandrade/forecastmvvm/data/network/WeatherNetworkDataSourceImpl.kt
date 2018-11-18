package com.example.franciscoandrade.forecastmvvm.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.franciscoandrade.forecastmvvm.data.network.response.CurrentWeatherResponse
import com.example.franciscoandrade.forecastmvvm.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl (
    private val apixWeatherApiService: ApixWeatherApiService
): WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()

    override val downloadedCurrentWather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val fetchCurrentWeather = apixWeatherApiService
                .getCurrentWeather(location, languageCode)
                .await()
            _downloadedCurrentWeather.postValue(fetchCurrentWeather)
        }catch (e: NoConnectivityException){
            Log.e("Connectivity", "No internet connection")
        }
    }
}