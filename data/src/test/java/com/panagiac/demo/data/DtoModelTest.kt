package com.panagiac.demo.data

import com.panagiac.demo.data.models.ForecastDTO
import com.panagiac.demo.data.tools.ResourceHelper
import org.junit.Before
import org.junit.Test

class DtoModelTest {
    private lateinit var forecastDTO: ForecastDTO

    @Before
    fun createDataSource() {
        ResourceHelper.getFile(API_MOCK_FILE, ForecastDTO::class.java)?.let {
            forecastDTO = it
        }
    }

    @Test
    fun isSizeCorrect() {
        forecastDTO.list?.isNotEmpty()?.let { assert(it) }
    }
}