package com.panagiac.demo.domain.usecase

import com.panagiac.demo.domain.models.Forecast
import io.reactivex.Single

interface DetailUseCase {
    fun getForecastByCityName(cityName: String): Single<Forecast>
}