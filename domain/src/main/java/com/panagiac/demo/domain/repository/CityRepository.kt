package com.panagiac.demo.domain.repository

import com.panagiac.demo.domain.models.misc.City
import io.reactivex.Single

interface CityRepository {
    fun getCities(): Single<List<City>>
}