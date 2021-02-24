package com.panagiac.demo.di

import com.panagiac.demo.domain.usecase.ForecastUseCase
import com.panagiac.demo.domain.usecase.ForecastUseCaseImpl
import org.koin.dsl.module

val useCasesModule = module {
    factory<ForecastUseCase> { ForecastUseCaseImpl(forecastRepository = get()) }
}