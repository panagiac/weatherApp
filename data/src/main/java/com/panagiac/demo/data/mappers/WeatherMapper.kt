package com.panagiac.demo.data.mappers

import com.panagiac.demo.data.extensions.toCelsius
import com.panagiac.demo.data.mappers.misc.*
import com.panagiac.demo.data.models.WeatherDTO
import com.panagiac.demo.domain.models.Weather
import com.panagiac.demo.domain.models.misc.*

class WeatherMapper : BaseMapper<WeatherDTO, Weather> {
    override fun mapFrom(from: WeatherDTO): Weather {
        return Weather(
            icon = from.weather?.get(0)?.icon
                ?.let { "https://openweathermap.org/img/wn/$it@2x.png" } ?: "",
            name = from.name.toString(),
            main = from.weather?.get(0)?.main.toString(),
            description = from.weather?.get(0)?.description.toString(),
            temp = from.main?.temp?.toCelsius()?.toInt() ?: 0,
            tempMin = from.main?.temp_min?.toCelsius()?.toInt() ?: 0,
            tempMax = from.main?.temp_max?.toCelsius()?.toInt() ?: 0
        )
    }

    override fun mapFrom(from: List<WeatherDTO>): List<Weather> {
        return from.map { mapFrom(it) }
    }
}