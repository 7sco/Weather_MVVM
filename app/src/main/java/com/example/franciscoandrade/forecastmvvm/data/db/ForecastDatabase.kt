package com.example.franciscoandrade.forecastmvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.franciscoandrade.forecastmvvm.data.db.entity.CurrentWeatherEntry

@Database(
    entities = [CurrentWeatherEntry::class],
    version = 1
)
abstract class ForecastDatabase :RoomDatabase(){
    abstract fun currentWeatherDao(): CurrentWeatherDao

    //Singleton
    companion object {
        //volatile = all threads have access
        @Volatile private var instance : ForecastDatabase? = null
        //no 2 threads are doing same thing
        private val LOCK= Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
                ForecastDatabase::class.java, "forecast.db").build()

    }
}