package com.panagiac.demo.domain.usecase

import com.panagiac.demo.domain.models.misc.City
import com.panagiac.demo.domain.models.Forecast
import com.panagiac.demo.domain.models.Weather
import com.panagiac.demo.domain.repository.CityRepository
import com.panagiac.demo.domain.repository.ForecastRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class HomeUseCaseImpl(
    private val forecastRepository: ForecastRepository,
    private val cityRepository: CityRepository
) : HomeUseCase {
    override fun getWeatherByCityName(cityName: String): Single<Weather> {
        return forecastRepository.getWeather(cityName)
            .subscribeOn(Schedulers.io())
    }

    override fun getListOfCities(): Single<List<City>> {
        return cityRepository.getCities()
            .subscribeOn(Schedulers.io())
    }
}