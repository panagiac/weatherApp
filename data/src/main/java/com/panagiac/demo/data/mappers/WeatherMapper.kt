package com.panagiac.demo.data.mappers

import com.panagiac.demo.data.mappers.misc.*
import com.panagiac.demo.data.models.WeatherDTO
import com.panagiac.demo.domain.models.Weather
import com.panagiac.demo.domain.models.misc.*

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
            base = from.base.toString(),
            clouds = from.clouds?.let { cloudsMapper.mapFrom(it) } ?: Clouds(0),
            cod = from.cod ?: 0,
            coord = from.coord?.let { coordsMapper.mapFrom(it) } ?: Coord(0.0, 0.0),
            dt = from.dt ?: 0,
            id = from.id ?: 0,
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
            name = from.name.toString(),
            sys = from.sys?.let { sysMapper.mapFrom(it) } ?: Sys(""),
            visibility = from.visibility ?: 0,
            weather = from.weather?.let { weatherItemMapper.mapFrom(it) } ?: listOf(),
            wind = from.wind?.let { windMapper.mapFrom(it) } ?: Wind(0, 0.0)
        )
    }

    override fun mapFrom(from: List<WeatherDTO>): List<Weather> {
        return from.map { mapFrom(it) }
    }
}