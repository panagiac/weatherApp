package com.panagiac.demo.di

import com.panagiac.demo.domain.usecase.DetailUseCase
import com.panagiac.demo.domain.usecase.DetailUseCaseImpl
import com.panagiac.demo.domain.usecase.HomeUseCase
import com.panagiac.demo.domain.usecase.HomeUseCaseImpl
import org.koin.dsl.module

val useCasesModule = module {
    factory<HomeUseCase> {
        HomeUseCaseImpl(
            apiRepository = get(),
            cityRepository = get()
        )
    }

    factory<DetailUseCase> {
        DetailUseCaseImpl(
            apiRepository = get()
        )
    }
}