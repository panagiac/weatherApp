package com.panagiac.demo.data.mapper

import com.panagiac.demo.data.models.DayDTO
import com.panagiac.demo.domain.model.weather.Day

class DayMapper(
    private val mainMapper: MainMapper,
    private val weatherMapper: WeatherMapper
) : BaseMapper<DayDTO, Day> {
    override fun mapFrom(from: DayDTO): Day {
        return Day(
            dt = from.dt,
            dtText = from.dt_txt,
            main = mainMapper.mapFrom(from.main),
            pop = from.pop,
            visibility = from.visibility,
            weather = weatherMapper.mapFrom(from.weather)
        )
    }

    override fun mapFrom(from: List<DayDTO>): List<Day> {
        return from.map { mapFrom(it) }
    }
}