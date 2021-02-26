package com.panagiac.demo.data.mapper

import com.panagiac.demo.data.models.HourDTO
import com.panagiac.demo.domain.model.weather.Hour

class HourMapper(
    private val mainMapper: MainMapper,
    private val weatherMapper: WeatherMapper
) : BaseMapper<HourDTO, Hour> {
    override fun mapFrom(from: HourDTO): Hour {
        return Hour(
            dt = from.dt,
            dtText = from.dt_txt,
            main = mainMapper.mapFrom(from.main),
            pop = from.pop,
            visibility = from.visibility,
            weather = weatherMapper.mapFrom(from.weather)
        )
    }

    override fun mapFrom(from: List<HourDTO>): List<Hour> {
        return from.map { mapFrom(it) }
    }
}