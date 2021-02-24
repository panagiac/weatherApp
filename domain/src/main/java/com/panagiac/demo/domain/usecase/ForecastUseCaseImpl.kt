package com.panagiac.demo.domain.usecase

import com.panagiac.demo.domain.model.Forecast
import com.panagiac.demo.domain.repository.ForecastRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class ForecastUseCaseImpl(private val forecastRepository: ForecastRepository) : ForecastUseCase {
    override fun getWeatherByCityName(cityName: String): Single<Forecast> {
        return forecastRepository.getForecast(cityName)
            .subscribeOn(Schedulers.io())
    }
}