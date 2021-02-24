package com.panagiac.demo.domain.usecase

import com.panagiac.demo.domain.model.Forecast
import io.reactivex.Single

interface ForecastUseCase {
    fun getWeatherByCityName(cityName: String): Single<Forecast>
}