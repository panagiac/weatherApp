package com.panagiac.demo.data

import com.panagiac.demo.data.mappers.ForecastMapper
import com.panagiac.demo.data.mappers.WeatherMapper
import com.panagiac.demo.data.mappers.misc.*
import com.panagiac.demo.data.network.service.MockApi
import com.panagiac.demo.data.network.service.OpenWeatherApi
import com.panagiac.demo.data.repository.ApiRepositoryImpl
import com.panagiac.demo.domain.repository.ApiRepository
import org.junit.Before
import org.junit.Test

class RepositoryTest {
    companion object {
        private const val CITY = "London"
    }

    private lateinit var repository: ApiRepository
    private val mockApi: OpenWeatherApi = MockApi()

    @Before
    fun prepare() {
        repository = ApiRepositoryImpl(
            apiService = mockApi,
            weatherMapper = WeatherMapper(
                cloudsMapper = CloudsMapper(),
                windMapper = WindMapper(),
                weatherItemMapper = WeatherItemMapper(),
                sysMapper = SysMapper(),
                mainMapper = MainMapper(),
                coordsMapper = CoordsMapper()
            ),
            forecastMapper = ForecastMapper(
                HourMapper(
                    mainMapper = MainMapper(),
                    weatherItemMapper = WeatherItemMapper()
                )
            )
        )
    }

    @Test
    fun assert_isForecastNotEmpty() {
        assert(repository.getForecast("q").blockingGet().list.count() > 0)
    }

    @Test
    fun assert_weatherCityNameEqualsLondon() {
        assert(repository.getWeather("q").blockingGet().name == CITY)
    }
}