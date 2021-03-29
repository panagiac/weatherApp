package com.panagiac.demo.di

import com.panagiac.demo.data.mappers.ForecastMapper
import com.panagiac.demo.data.mappers.WeatherMapper
import com.panagiac.demo.data.mappers.CityMapper
import com.panagiac.demo.data.mappers.HourMapper
import org.koin.dsl.module

val mappersModule = module {
    factory { CityMapper() }
    factory { WeatherMapper() }
    factory { HourMapper() }
    factory { ForecastMapper(hourMapper = get()) }
}