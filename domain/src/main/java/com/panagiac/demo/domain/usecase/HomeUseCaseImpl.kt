package com.panagiac.demo.domain.usecase

import com.panagiac.demo.domain.models.City
import com.panagiac.demo.domain.models.Weather
import com.panagiac.demo.domain.repository.CityRepository
import com.panagiac.demo.domain.repository.ApiRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class HomeUseCaseImpl(
    private val apiRepository: ApiRepository,
    private val cityRepository: CityRepository
) : HomeUseCase {
    override fun getWeatherByCityName(cityName: String): Single<Weather> {
        return apiRepository.getWeather(cityName)
            .subscribeOn(Schedulers.io())
    }

    override fun getListOfCities(): Single<List<City>> {
        return cityRepository.getCities()
            .subscribeOn(Schedulers.io())
    }
}