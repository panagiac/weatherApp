package com.panagiac.demo.data.network.service

import com.panagiac.demo.data.FORECAST
import com.panagiac.demo.data.WEATHER
import com.panagiac.demo.data.models.dto.ForecastDTO
import com.panagiac.demo.data.models.dto.WeatherDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {
    @GET(WEATHER)
    fun getWeather(@Query("q") q: String): Single<WeatherDTO>

    @GET(FORECAST)
    fun getForecast(@Query("q") q: String): Single<ForecastDTO>
}