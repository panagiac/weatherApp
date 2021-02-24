@file:Suppress("unused")

package com.panagiac.demo.weatherapp

import android.app.Application
import com.panagiac.demo.di.mappersModule
import com.panagiac.demo.di.networkModule
import com.panagiac.demo.di.repositoryModule
import com.panagiac.demo.di.useCasesModule
import com.panagiac.demo.weatherapp.ui.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)

            modules(
                networkModule,
                mappersModule,
                repositoryModule,
                useCasesModule,
                module {
                    viewModel { MainViewModel(useCase = get()) }
                }
            )
        }
    }
}