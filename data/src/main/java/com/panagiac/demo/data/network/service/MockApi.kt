package com.panagiac.demo.data.network.service

import com.panagiac.demo.data.API_MOCK_FILE
import com.panagiac.demo.data.models.ForecastDTO
import com.panagiac.demo.data.tools.ResourceHelper
import io.reactivex.Single

class MockApi : ForecastApi {
    override fun getForecast(q: String): Single<ForecastDTO> {
        return Single.fromCallable {
            ResourceHelper.getFile(API_MOCK_FILE, ForecastDTO::class.java)
        }
    }
}