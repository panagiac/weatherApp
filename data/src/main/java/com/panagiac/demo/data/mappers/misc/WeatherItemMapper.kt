package com.panagiac.demo.data.mappers.misc

import com.panagiac.demo.data.mappers.BaseMapper
import com.panagiac.demo.data.models.misc.WeatherItemDTO
import com.panagiac.demo.domain.models.misc.WeatherItem

class WeatherItemMapper : BaseMapper<WeatherItemDTO, WeatherItem> {
    override fun mapFrom(from: WeatherItemDTO): WeatherItem {
        return WeatherItem(
            description = from.description.toString(),
            icon = from.icon.toString(),
            id = from.id ?: 0,
            main = from.main.toString()
        )
    }

    override fun mapFrom(from: List<WeatherItemDTO>): List<WeatherItem> {
        return from.map { mapFrom(it) }
    }
}