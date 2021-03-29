package com.panagiac.demo.data

import com.panagiac.demo.data.models.dto.WeatherDTO
import com.panagiac.demo.data.tools.ResourceHelper
import org.junit.Before
import org.junit.Test

class WeatherModelTest {
    companion object {
        private const val CITY = "London"
    }

    private var weatherDTO: WeatherDTO? = null

    @Before
    fun createDataSource() {
        ResourceHelper.getFile(WEATHER_API_MOCK, WeatherDTO::class.java)?.let {
            weatherDTO = it
        }
    }

    @Test
    fun assert_cityNameEqualsLondon() {
        assert(weatherDTO?.name == CITY)
    }
}