package com.panagiac.demo.domain.usecase

import com.panagiac.demo.domain.models.misc.City
import com.panagiac.demo.domain.models.Forecast
import com.panagiac.demo.domain.models.Weather
import io.reactivex.Single

interface HomeUseCase {
    fun getWeatherByCityName(cityName: String): Single<Weather>
    fun getListOfCities(): Single<List<City>>
}