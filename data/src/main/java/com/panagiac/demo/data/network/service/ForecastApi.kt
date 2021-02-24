package com.panagiac.demo.data.network.service

import com.panagiac.demo.data.FORECAST
import com.panagiac.demo.data.network.dto.ForecastDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastApi {
    @GET(FORECAST)
    fun getForecast(@Query("q") q: String): Single<ForecastDTO>
}