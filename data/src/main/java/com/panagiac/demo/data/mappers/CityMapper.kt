package com.panagiac.demo.data.mappers

import com.panagiac.demo.data.models.dao.CitiesDAOItem
import com.panagiac.demo.domain.BaseMapper
import com.panagiac.demo.domain.models.City

class CityMapper: BaseMapper<CitiesDAOItem, City> {
    override fun mapFrom(from: CitiesDAOItem): City {
        return City(
            name = from.name,
            country = from.country
        )
    }

    override fun mapFrom(from: List<CitiesDAOItem>): List<City> {
        return from.map { mapFrom(it) }
    }
}