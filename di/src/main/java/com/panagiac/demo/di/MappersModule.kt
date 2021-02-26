package com.panagiac.demo.di

import com.panagiac.demo.data.mappers.*
import com.panagiac.demo.data.mappers.misc.*
import org.koin.dsl.module

val mappersModule = module {
    factory { CityMapper() }
    factory { CloudsMapper() }
    factory { CoordsMapper() }
    factory { ForecastMapper(hourMapper = get()) }
    factory {
        HourMapper(
            mainMapper = get(),
            weatherItemMapper = get()
        )
    }
    factory { MainMapper() }
    factory { SysMapper() }
    factory { WeatherItemMapper() }
    factory {
        WeatherMapper(
            cloudsMapper = get(),
            coordsMapper = get(),
            mainMapper = get(),
            sysMapper = get(),
            weatherItemMapper = get(),
            windMapper = get()
        )
    }
    factory { WindMapper() }
}