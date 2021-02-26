package com.panagiac.demo.domain.usecase

import com.panagiac.demo.domain.models.Forecast
import com.panagiac.demo.domain.repository.ForecastRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class DetailUseCaseImpl(private val forecastRepository: ForecastRepository) : DetailUseCase {
    override fun getForecastByCityName(cityName: String): Single<Forecast> {
        return forecastRepository.getForecast(cityName)
            .subscribeOn(Schedulers.io())
    }
}