package com.panagiac.demo.domain.usecase

import com.panagiac.demo.domain.models.Forecast
import com.panagiac.demo.domain.repository.ApiRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class DetailUseCaseImpl(private val apiRepository: ApiRepository) : DetailUseCase {
    override fun getForecastByCityName(cityName: String): Single<Forecast> {
        return apiRepository.getForecast(cityName)
            .subscribeOn(Schedulers.io())
    }
}