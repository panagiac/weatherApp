package com.panagiac.demo.data.mappers.misc

import com.panagiac.demo.data.extensions.toCelsius
import com.panagiac.demo.data.extensions.toDate
import com.panagiac.demo.data.extensions.toReadableDate
import com.panagiac.demo.data.mappers.BaseMapper
import com.panagiac.demo.data.models.misc.HourDTO
import com.panagiac.demo.domain.models.misc.Hour

class HourMapper : BaseMapper<HourDTO, Hour> {
    override fun mapFrom(from: HourDTO): Hour {
        return Hour(
            temp = from.main?.temp?.toCelsius()?.toInt() ?: 0,
            dt = from.dt ?: 0,
            dtText = from.dt_txt?.toDate()?.toReadableDate() ?: "",
            icon = from.weather?.get(0)?.icon
                ?.let { "https://openweathermap.org/img/wn/$it@2x.png" } ?: ""
        )
    }

    override fun mapFrom(from: List<HourDTO>): List<Hour> {
        return from.map { mapFrom(it) }
    }
}