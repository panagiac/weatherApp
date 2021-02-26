package com.panagiac.demo.di

import com.panagiac.demo.data.repository.CityRepositoryImpl
import com.panagiac.demo.data.repository.ApiRepositoryImpl
import com.panagiac.demo.domain.repository.CityRepository
import com.panagiac.demo.domain.repository.ApiRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<ApiRepository> {
        ApiRepositoryImpl(
            apiService = get(),
            forecastMapper = get(),
            weatherMapper = get()
        )
    }

    factory<CityRepository> {
        CityRepositoryImpl(mapper = get())
    }
}