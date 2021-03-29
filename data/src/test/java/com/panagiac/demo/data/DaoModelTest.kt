package com.panagiac.demo.data

import com.panagiac.demo.data.mappers.misc.CityMapper
import com.panagiac.demo.data.repository.CityRepositoryImpl
import com.panagiac.demo.domain.models.misc.City
import org.junit.Before
import org.junit.Test

class DaoModelTest {
    private var cityRepositoryImpl = CityRepositoryImpl(CityMapper())
    private lateinit var cities: List<City>

    @Before
    fun createData() {
        cities = cityRepositoryImpl.getCities().blockingGet()
    }

    @Test
    fun assert_isNotEmpty() {
        assert(cities.isNotEmpty())
    }
}