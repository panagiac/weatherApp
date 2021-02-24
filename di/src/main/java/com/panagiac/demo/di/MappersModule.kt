package com.panagiac.demo.di

import com.panagiac.demo.data.mapper.ForecastMapper
import org.koin.dsl.module

val mappersModule = module {
    factory { ForecastMapper() }
}