package com.panagiac.demo.domain.usecase

import com.panagiac.demo.domain.model.weather.City
import com.panagiac.demo.domain.model.weather.Forecast
import io.reactivex.Single

interface ForecastUseCase {
    fun getWeatherByCityName(cityName: String): Single<Forecast>
    fun getListOfCities(): Single<List<City>>
}