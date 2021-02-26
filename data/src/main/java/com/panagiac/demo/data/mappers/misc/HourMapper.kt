package com.panagiac.demo.data.mappers.misc

import com.panagiac.demo.data.mappers.BaseMapper
import com.panagiac.demo.data.models.misc.HourDTO
import com.panagiac.demo.domain.models.misc.Hour

class HourMapper(
    private val mainMapper: MainMapper,
    private val weatherItemMapper: WeatherItemMapper
) : BaseMapper<HourDTO, Hour> {
    override fun mapFrom(from: HourDTO): Hour {
        return Hour(
            dt = from.dt,
            dtText = from.dt_txt,
            main = mainMapper.mapFrom(from.main),
            pop = from.pop,
            visibility = from.visibility,
            weatherItem = weatherItemMapper.mapFrom(from.weatherItem)
        )
    }

    override fun mapFrom(from: List<HourDTO>): List<Hour> {
        return from.map { mapFrom(it) }
    }
}