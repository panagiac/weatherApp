package com.panagiac.demo.data.repository

import com.panagiac.demo.data.CITIES_DB
import com.panagiac.demo.data.mappers.CityMapper
import com.panagiac.demo.data.models.dao.CitiesDAO
import com.panagiac.demo.data.tools.ResourceHelper
import com.panagiac.demo.domain.models.City
import com.panagiac.demo.domain.repository.CityRepository
import io.reactivex.Single

class CityRepositoryImpl(private val mapper: CityMapper) : CityRepository {
    override fun getCities(): Single<List<City>> {
        return Single.fromCallable {
            ResourceHelper.getFile(CITIES_DB, CitiesDAO::class.java)
        }.map { t ->
            t?.toList()?.let {
                mapper.mapFrom(it)
            }
        }
    }
}