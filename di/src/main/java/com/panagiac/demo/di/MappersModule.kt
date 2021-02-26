package com.panagiac.demo.di

import com.panagiac.demo.data.mapper.*
import org.koin.dsl.module

val mappersModule = module {
    factory { MainMapper() }
    factory { WeatherMapper() }
    factory { HourMapper(mainMapper = get(), weatherMapper = get()) }
    factory { ForecastMapper(hourMapper = get()) }
    factory { CityMapper() }
}