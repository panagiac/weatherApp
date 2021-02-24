package com.panagiac.demo.weatherapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.panagiac.demo.domain.model.Forecast
import com.panagiac.demo.domain.model.Response
import com.panagiac.demo.domain.usecase.ForecastUseCase
import com.panagiac.demo.weatherapp.base.BaseViewModel
import com.panagiac.demo.weatherapp.extensions.set
import com.panagiac.demo.domain.model.Response.Companion.Status

class MainViewModel(private val useCase: ForecastUseCase) : BaseViewModel() {

    private val forecast = MutableLiveData<Response<Forecast>>()
    fun getForecast(): LiveData<Response<Forecast>> = forecast

    fun weather(cityName: String) {
        forecast.set(status = Status.LOADING)

        doApiCall(
            apiCall = useCase.getWeatherByCityName(cityName),
            onSuccess = {
                forecast.set(
                    data = it,
                    status = Status.SUCCESSFUL
                )
            },
            onError = {
                forecast.set(status = Status.ERROR)
            }
        )
    }
}