package com.panagiac.demo.data.mapper

import com.panagiac.demo.data.models.ForecastDTO
import com.panagiac.demo.domain.model.Forecast

class ForecastMapper : BaseMapper<ForecastDTO, Forecast> {
    override fun mapFrom(from: ForecastDTO): Forecast {
        return Forecast(
            cnt = from.cnt ?: 0,
            cod = from.cod.toString(),
            message = from.message ?: 0
        )
    }

    override fun mapFrom(from: List<ForecastDTO>): List<Forecast> {
        return from.map { mapFrom(it) }
    }
}