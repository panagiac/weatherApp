package com.panagiac.demo.data

import com.google.gson.Gson
import com.panagiac.demo.data.network.dto.ForecastDTO
import org.junit.Before
import org.junit.Test
import java.io.File

class DtoModelTest {
    companion object {
        private const val FILENAME = "api_weather.json"
    }

    private lateinit var forecastDTO: ForecastDTO

    @Before
    fun createDataSource() {
        val uri = this.javaClass.classLoader?.getResource(FILENAME)
        uri?.let {
            val file = File(uri.path)
            val json = String(file.readBytes())

            forecastDTO = Gson().fromJson(json, ForecastDTO::class.java)
        }
    }

    @Test
    fun isSizeCorrect() {
        forecastDTO.list?.isNotEmpty()?.let { assert(it) }
    }
}