package com.example.franciscoandrade.forecastmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.franciscoandrade.forecastmvvm.data.db.entity.CURRENT_WEATHER_ID
import com.example.franciscoandrade.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.example.franciscoandrade.forecastmvvm.data.unitlocalized.ImperialCurrentWeatherEntry
import com.example.franciscoandrade.forecastmvvm.data.unitlocalized.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    //Update or Insert at the same time
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query(value = "select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query(value = "select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}