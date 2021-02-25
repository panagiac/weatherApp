package com.panagiac.demo.data

import com.panagiac.demo.data.network.dto.ForecastDTO
import com.panagiac.demo.data.tools.ResourceHelper
import org.junit.Before
import org.junit.Test

class DtoModelTest {
    companion object {
        private const val FILENAME = "api_weather.json"
    }

    private lateinit var forecastDTO: ForecastDTO

    @Before
    fun createDataSource() {
        ResourceHelper.getFile(FILENAME, ForecastDTO::class.java)?.let {
            forecastDTO = it
        }
    }

    @Test
    fun isSizeCorrect() {
        forecastDTO.list?.isNotEmpty()?.let { assert(it) }
    }
}