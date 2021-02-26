package com.panagiac.demo.data.repository

import com.panagiac.demo.data.mappers.ForecastMapper
import com.panagiac.demo.data.mappers.WeatherMapper
import com.panagiac.demo.data.network.service.ForecastApi
import com.panagiac.demo.domain.models.Forecast
import com.panagiac.demo.domain.models.Weather
import com.panagiac.demo.domain.repository.ForecastRepository
import io.reactivex.Single

class ForecastRepositoryImpl(
    private val apiService: ForecastApi,
    private val weatherMapper: WeatherMapper,
    private val forecastMapper: ForecastMapper
) : ForecastRepository {
    override fun getWeather(cityName: String): Single<Weather> {
        return apiService.getWeather(cityName)
            .map { t -> weatherMapper.mapFrom(t) }
    }

    override fun getForecast(cityName: String): Single<Forecast> {
        return apiService.getForecast(cityName)
            .map { t -> forecastMapper.mapFrom(t) }
    }
}