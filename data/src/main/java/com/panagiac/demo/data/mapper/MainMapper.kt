package com.panagiac.demo.data.mapper

import com.panagiac.demo.data.models.MainDTO
import com.panagiac.demo.domain.model.weather.Main

class MainMapper : BaseMapper<MainDTO, Main> {
    override fun mapFrom(from: MainDTO): Main {
        return Main(
            feelsLike = from.feels_like,
            grndLevel = from.grnd_level,
            humidity = from.humidity,
            pressure = from.pressure,
            seaLevel = from.sea_level,
            temp = from.temp,
            tempKf = from.temp_kf,
            tempMax = from.temp_max,
            tempMin = from.temp_min
        )
    }

    override fun mapFrom(from: List<MainDTO>): List<Main> {
        return from.map { mapFrom(it) }
    }
}