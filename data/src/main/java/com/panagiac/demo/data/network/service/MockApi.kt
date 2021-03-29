package com.panagiac.demo.data.network.service

import com.panagiac.demo.data.FORECAST_API_MOCK
import com.panagiac.demo.data.WEATHER_API_MOCK
import com.panagiac.demo.data.models.dto.ForecastDTO
import com.panagiac.demo.data.models.dto.WeatherDTO
import com.panagiac.demo.data.tools.ResourceHelper
import io.reactivex.Single

class MockApi : OpenWeatherApi {
    override fun getWeather(q: String): Single<WeatherDTO> {
        return Single.fromCallable {
            ResourceHelper.getFile(WEATHER_API_MOCK, WeatherDTO::class.java)
        }
    }

    override fun getForecast(q: String): Single<ForecastDTO> {
        return Single.fromCallable {
            ResourceHelper.getFile(FORECAST_API_MOCK, ForecastDTO::class.java)
        }
    }
}