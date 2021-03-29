package com.panagiac.demo.weatherapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.panagiac.demo.domain.models.Forecast
import com.panagiac.demo.domain.Response
import com.panagiac.demo.domain.Response.Companion.Status
import com.panagiac.demo.domain.usecase.DetailUseCase
import com.panagiac.demo.weatherapp.base.BaseViewModel
import com.panagiac.demo.weatherapp.extensions.set

class DetailViewModel(private val useCase: DetailUseCase) : BaseViewModel() {

    private var cachedForecast: Forecast? = null

    private val forecast = MutableLiveData<Response<Forecast>>()
    fun getForecast(): LiveData<Response<Forecast>> = forecast

    fun forecast(cityName: String) {
        forecast.set(status = Status.LOADING)

        when {
            (cachedForecast != null) -> {
                forecast.set(
                    data = cachedForecast,
                    status = Status.SUCCESSFUL
                )
            }
            else -> {
                doAsync(
                    asyncAction = useCase.getForecastByCityName(cityName),
                    onSuccess = {
                        cachedForecast = it
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
    }
}