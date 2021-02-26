package com.panagiac.demo.data.repository

import com.panagiac.demo.data.mappers.ForecastMapper
import com.panagiac.demo.data.mappers.WeatherMapper
import com.panagiac.demo.data.network.service.OpenWeatherApi
import com.panagiac.demo.domain.models.Forecast
import com.panagiac.demo.domain.models.Weather
import com.panagiac.demo.domain.repository.ApiRepository
import io.reactivex.Single

class ApiRepositoryImpl(
    private val apiService: OpenWeatherApi,
    private val weatherMapper: WeatherMapper,
    private val forecastMapper: ForecastMapper
) : ApiRepository {
    override fun getWeather(cityName: String): Single<Weather> {
        return apiService.getWeather(cityName)
            .map { t -> weatherMapper.mapFrom(t) }
    }

    override fun getForecast(cityName: String): Single<Forecast> {
        return apiService.getForecast(cityName)
            .map { t -> forecastMapper.mapFrom(t) }
    }
}