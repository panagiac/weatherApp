package com.panagiac.demo.domain.repository

import com.panagiac.demo.domain.model.Forecast
import io.reactivex.Single

interface ForecastRepository {
    fun getForecast(cityName: String): Single<Forecast>
}