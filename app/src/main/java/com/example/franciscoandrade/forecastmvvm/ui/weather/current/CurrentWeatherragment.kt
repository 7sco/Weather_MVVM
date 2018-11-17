package com.example.franciscoandrade.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.franciscoandrade.forecastmvvm.R

class CurrentWeatherragment : Fragment() {

    companion object {
        fun newInstance() = CurrentWeatherragment()
    }

    private lateinit var viewModel: CurrentWeatherragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
