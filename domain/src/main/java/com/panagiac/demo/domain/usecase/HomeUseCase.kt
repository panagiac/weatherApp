package com.panagiac.demo.domain.usecase

import com.panagiac.demo.domain.models.Weather
import com.panagiac.demo.domain.models.City
import io.reactivex.Single

interface HomeUseCase {
    fun getWeatherByCityName(cityName: String): Single<Weather>
    fun getListOfCities(): Single<List<City>>
}