package com.panagiac.demo.di

import com.panagiac.demo.data.repository.CityRepositoryImpl
import com.panagiac.demo.data.repository.ForecastRepositoryImpl
import com.panagiac.demo.domain.repository.CityRepository
import com.panagiac.demo.domain.repository.ForecastRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<ForecastRepository> {
        ForecastRepositoryImpl(
            apiService = get(),
            forecastMapper = get(),
            weatherMapper = get()
        )
    }

    factory<CityRepository> {
        CityRepositoryImpl(mapper = get())
    }
}