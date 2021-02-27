package com.panagiac.demo.weatherapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.panagiac.demo.domain.models.Response
import com.panagiac.demo.domain.usecase.HomeUseCase
import com.panagiac.demo.weatherapp.base.BaseViewModel
import com.panagiac.demo.weatherapp.extensions.set
import com.panagiac.demo.domain.models.Response.Companion.Status
import com.panagiac.demo.domain.models.Weather
import com.panagiac.demo.domain.models.misc.City

class HomeViewModel(private val useCase: HomeUseCase) : BaseViewModel() {
    companion object {
        private const val COUNTRY = "IT"
    }

    private val cities = MutableLiveData<Response<List<String>>>()
    fun getCities(): LiveData<Response<List<String>>> = cities

    private val weather = MutableLiveData<Response<Weather>>()
    fun getWeather(): LiveData<Response<Weather>> = weather

    var selectedWeather: Weather? = null
        private set

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
        weather.set(status = Status.LOADING)

        doAsync(
            asyncAction = useCase.getWeatherByCityName(cityName),
            onSuccess = {
                selectedWeather = it

                weather.set(
                    data = it,
                    status = Status.SUCCESSFUL
                )
            },
            onError = {
                selectedWeather = null

                weather.set(
                    status = Status.ERROR,
                    errorMessage = it.message
                )
            }
        )
    }
}