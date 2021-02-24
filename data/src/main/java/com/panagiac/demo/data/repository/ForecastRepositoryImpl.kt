package com.panagiac.demo.data.repository

import com.panagiac.demo.data.mapper.ForecastMapper
import com.panagiac.demo.data.network.service.ForecastApi
import com.panagiac.demo.domain.model.Forecast
import com.panagiac.demo.domain.repository.ForecastRepository
import io.reactivex.Single

class ForecastRepositoryImpl(
    private val apiService: ForecastApi,
    private val forecastMapper: ForecastMapper
) : ForecastRepository {
    override fun getForecast(cityName: String): Single<Forecast> {
        return apiService.getForecast(cityName)
            .map { t -> forecastMapper.mapFrom(t) }
    }
}