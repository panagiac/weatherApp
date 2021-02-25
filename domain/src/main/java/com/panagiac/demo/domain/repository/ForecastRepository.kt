package com.panagiac.demo.domain.repository

import com.panagiac.demo.domain.model.weather.Forecast
import io.reactivex.Single

interface ForecastRepository {
    fun getForecast(cityName: String): Single<Forecast>
}