package com.panagiac.demo.data

import com.panagiac.demo.data.mapper.CityMapper
import com.panagiac.demo.data.repository.CityRepositoryImpl
import com.panagiac.demo.domain.model.weather.City
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
    fun isPopulated() {
        assert(cities.isNotEmpty())
    }
}