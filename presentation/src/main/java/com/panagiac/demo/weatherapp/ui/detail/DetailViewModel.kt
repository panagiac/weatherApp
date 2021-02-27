package com.panagiac.demo.weatherapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.panagiac.demo.domain.models.Forecast
import com.panagiac.demo.domain.models.Response
import com.panagiac.demo.domain.models.Response.Companion.Status
import com.panagiac.demo.domain.usecase.DetailUseCase
import com.panagiac.demo.weatherapp.base.BaseViewModel
import com.panagiac.demo.weatherapp.extensions.set

class DetailViewModel(private val useCase: DetailUseCase) : BaseViewModel() {

    private val forecast = MutableLiveData<Response<Forecast>>()
    fun getForecast(): LiveData<Response<Forecast>> = forecast

    fun forecast(cityName: String) {
        forecast.set(status = Status.LOADING)

        doAsync(
            asyncAction = useCase.getForecastByCityName(cityName),
            onSuccess = {
                forecast.set(
                    data = it,
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