package com.panagiac.demo.domain.repository

import com.panagiac.demo.domain.models.Forecast
import com.panagiac.demo.domain.models.Weather
import io.reactivex.Single

interface ForecastRepository {
    fun getWeather(cityName: String): Single<Weather>
    fun getForecast(cityName: String): Single<Forecast>
}