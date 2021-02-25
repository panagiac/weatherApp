package com.panagiac.demo.di

import com.panagiac.demo.data.mapper.*
import org.koin.dsl.module

val mappersModule = module {
    factory { MainMapper() }
    factory { WeatherMapper() }
    factory { DayMapper(mainMapper = get(), weatherMapper = get()) }
    factory { ForecastMapper(dayMapper = get()) }
    factory { CityMapper() }
}