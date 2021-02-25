package com.panagiac.demo.data.network.service

import com.panagiac.demo.data.network.dto.ForecastDTO
import com.panagiac.demo.data.tools.ResourceHelper
import io.reactivex.Single

class MockApi : ForecastApi {
    override fun getForecast(q: String): Single<ForecastDTO> {
        return Single.fromCallable {
            ResourceHelper.getFile("api_weather.json", ForecastDTO::class.java)
        }
    }
}