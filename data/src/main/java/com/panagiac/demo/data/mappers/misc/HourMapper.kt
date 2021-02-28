package com.panagiac.demo.data.mappers.misc

import com.panagiac.demo.data.mappers.BaseMapper
import com.panagiac.demo.data.models.misc.HourDTO
import com.panagiac.demo.domain.models.misc.Hour
import com.panagiac.demo.domain.models.misc.Main

class HourMapper(
    private val mainMapper: MainMapper,
    private val weatherItemMapper: WeatherItemMapper
) : BaseMapper<HourDTO, Hour> {
    override fun mapFrom(from: HourDTO): Hour {
        return Hour(
            dt = from.dt ?: 0,
            dtText = from.dt_txt.toString(),
            main = from.main?.let { mainMapper.mapFrom(it) } ?: Main(
                0.0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
            ),
            pop = from.pop ?: 0.0,
            visibility = from.visibility ?: 0,
            weather = from.weather?.let { weatherItemMapper.mapFrom(it) } ?: listOf()
        )
    }

    override fun mapFrom(from: List<HourDTO>): List<Hour> {
        return from.map { mapFrom(it) }
    }
}