package com.panagiac.demo.data.mappers

import com.panagiac.demo.data.mappers.misc.HourMapper
import com.panagiac.demo.data.models.ForecastDTO
import com.panagiac.demo.domain.models.Forecast

class ForecastMapper(private val hourMapper: HourMapper) : BaseMapper<ForecastDTO, Forecast> {
    override fun mapFrom(from: ForecastDTO): Forecast {
        return Forecast(
            cnt = from.cnt ?: 0,
            cod = from.cod.toString(),
            message = from.message ?: 0,
            list = from.list?.let { hourMapper.mapFrom(it) } ?: listOf(),
            name = ""
        )
    }

    override fun mapFrom(from: List<ForecastDTO>): List<Forecast> {
        return from.map { mapFrom(it) }
    }
}