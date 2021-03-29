package com.panagiac.demo.data

import com.panagiac.demo.data.models.ForecastDTO
import com.panagiac.demo.data.tools.ResourceHelper
import org.junit.Before
import org.junit.Test

class ForecastModelTest {
    private lateinit var forecastDTO: ForecastDTO

    @Before
    fun createDataSource() {
        ResourceHelper.getFile(FORECAST_API_MOCK, ForecastDTO::class.java)?.let {
            forecastDTO = it
        }
    }

    @Test
    fun assert_isNotEmpty() {
        forecastDTO.list?.isNotEmpty()?.let { assert(it) }
    }
}