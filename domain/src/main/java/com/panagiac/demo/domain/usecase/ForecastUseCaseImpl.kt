package com.panagiac.demo.domain.usecase

import com.panagiac.demo.domain.model.weather.City
import com.panagiac.demo.domain.model.weather.Forecast
import com.panagiac.demo.domain.repository.CityRepository
import com.panagiac.demo.domain.repository.ForecastRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class ForecastUseCaseImpl(
    private val forecastRepository: ForecastRepository,
    private val cityRepository: CityRepository
) : ForecastUseCase {
    override fun getWeatherByCityName(cityName: String): Single<Forecast> {
        return forecastRepository.getForecast(cityName)
            .subscribeOn(Schedulers.io())
    }

    override fun getListOfCities(): Single<List<City>> {
        return cityRepository.getCities()
            .subscribeOn(Schedulers.io())
    }
}