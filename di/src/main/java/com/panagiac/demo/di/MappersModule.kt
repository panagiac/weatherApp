package com.panagiac.demo.di

import com.panagiac.demo.data.mappers.*
import com.panagiac.demo.data.mappers.misc.*
import org.koin.dsl.module

val mappersModule = module {
    factory { CityMapper() }
    factory { CloudsMapper() }
    factory { CoordsMapper() }
    factory { ForecastMapper(hourMapper = get()) }
    factory { MainMapper() }
    factory { SysMapper() }
    factory { WeatherItemMapper() }


    factory { WindMapper() }

    factory { WeatherMapper() }
    factory { HourMapper() }
}