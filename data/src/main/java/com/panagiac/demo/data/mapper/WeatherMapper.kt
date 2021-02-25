package com.panagiac.demo.data.mapper

import com.panagiac.demo.data.models.WeatherDTO
import com.panagiac.demo.domain.model.weather.Weather

class WeatherMapper : BaseMapper<WeatherDTO, Weather> {
    override fun mapFrom(from: WeatherDTO): Weather {
        return Weather(
            description = from.description,
            icon = from.icon,
            id = from.id,
            main = from.main
        )
    }

    override fun mapFrom(from: List<WeatherDTO>): List<Weather> {
        return from.map { mapFrom(it) }
    }
}