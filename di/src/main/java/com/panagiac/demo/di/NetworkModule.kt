package com.panagiac.demo.di

import com.panagiac.demo.data.BASE_URL
import com.panagiac.demo.data.network.createNetworkClient
import com.panagiac.demo.data.network.service.ForecastApi
import com.panagiac.demo.data.network.service.MockApi
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single { createNetworkClient(androidApplication(), BASE_URL) }
    single { get<Retrofit>().create(ForecastApi::class.java) }

    single<ForecastApi>(named("mock")) { MockApi() }
}