package com.panagiac.demo.data.mappers.misc

import com.panagiac.demo.data.extensions.toCelsius
import com.panagiac.demo.data.mappers.BaseMapper
import com.panagiac.demo.data.models.misc.MainDTO
import com.panagiac.demo.domain.models.misc.Main

class MainMapper : BaseMapper<MainDTO, Main> {
    override fun mapFrom(from: MainDTO): Main {
        return Main(
            feelsLike = from.feels_like ?: 0.0,
            grndLevel = from.grnd_level ?: 0,
            humidity = from.humidity ?: 0,
            pressure = from.pressure ?: 0,
            seaLevel = from.sea_level ?: 0,
            temp = from.temp?.toCelsius()?.toInt() ?: 0,
            tempKf = from.temp_kf?.toCelsius()?.toInt() ?: 0,
            tempMax = from.temp_max?.toCelsius()?.toInt() ?: 0,
            tempMin = from.temp_min?.toCelsius()?.toInt() ?: 0
        )
    }

    override fun mapFrom(from: List<MainDTO>): List<Main> {
        return from.map { mapFrom(it) }
    }
}