package com.panagiac.demo.weatherapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.panagiac.demo.domain.models.Forecast
import com.panagiac.demo.domain.models.Response
import com.panagiac.demo.domain.usecase.ForecastUseCase
import com.panagiac.demo.weatherapp.base.BaseViewModel
import com.panagiac.demo.weatherapp.extensions.set
import com.panagiac.demo.domain.models.Response.Companion.Status

class MainViewModel(private val useCase: ForecastUseCase) : BaseViewModel() {
    companion object {
        private const val COUNTRY = "IT"
    }

    private val cities = MutableLiveData<Response<List<String>>>()
    fun getCities(): LiveData<Response<List<String>>> = cities

    private val forecast = MutableLiveData<Response<Forecast>>()
    fun getForecast(): LiveData<Response<Forecast>> = forecast

    init {
        populateCities()
    }

    private fun populateCities() {
        cities.set(status = Status.LOADING)

        doAsync(
            asyncAction = useCase.getListOfCities(),
            onSuccess = {
                cities.set(
                    data = it
                        .filter { t -> t.country == COUNTRY }
                        .map { t -> t.name }
                        .distinct(),
                    status = Status.SUCCESSFUL
                )
            },
            onError = {
                cities.set(
                    status = Status.ERROR,
                    errorMessage = it.message
                )
            }
        )
    }

    fun weather(cityName: String) {
        forecast.set(status = Status.LOADING)

        doAsync(
            asyncAction = useCase.getWeatherByCityName(cityName),
            onSuccess = {
                forecast.set(
                    data = it.apply {
                        name = cityName
                    },
                    status = Status.SUCCESSFUL
                )
            },
            onError = {
                forecast.set(
                    status = Status.ERROR,
                    errorMessage = it.message
                )
            }
        )
    }
}