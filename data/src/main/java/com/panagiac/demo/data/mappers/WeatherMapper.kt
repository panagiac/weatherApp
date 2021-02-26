package com.panagiac.demo.data.mappers

import com.panagiac.demo.data.mappers.misc.*
import com.panagiac.demo.data.models.WeatherDTO
import com.panagiac.demo.domain.models.Weather

class WeatherMapper(
    private val cloudsMapper: CloudsMapper,
    private val coordsMapper: CoordsMapper,
    private val mainMapper: MainMapper,
    private val sysMapper: SysMapper,
    private val weatherItemMapper: WeatherItemMapper,
    private val windMapper: WindMapper
) : BaseMapper<WeatherDTO, Weather> {
    override fun mapFrom(from: WeatherDTO): Weather {
        return Weather(
            base = from.base,
            clouds = cloudsMapper.mapFrom(from.clouds),
            cod = from.cod,
            coord = coordsMapper.mapFrom(from.coord),
            dt = from.dt,
            id = from.id,
            main = mainMapper.mapFrom(from.main),
            name = from.name,
            sys = sysMapper.mapFrom(from.sys),
            visibility = from.visibility,
            weather = weatherItemMapper.mapFrom(from.weather),
            wind = windMapper.mapFrom(from.wind)
        )
    }

    override fun mapFrom(from: List<WeatherDTO>): List<Weather> {
        return from.map { mapFrom(it) }
    }
}