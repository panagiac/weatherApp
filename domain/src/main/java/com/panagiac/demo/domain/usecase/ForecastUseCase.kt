package com.panagiac.demo.domain.usecase

import com.panagiac.demo.domain.models.misc.City
import com.panagiac.demo.domain.models.Forecast
import io.reactivex.Single

interface ForecastUseCase {
    fun getWeatherByCityName(cityName: String): Single<Forecast>
    fun getListOfCities(): Single<List<City>>
}