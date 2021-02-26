package com.panagiac.demo.data.mappers.misc

import com.panagiac.demo.data.mappers.BaseMapper
import com.panagiac.demo.data.models.misc.WindDTO
import com.panagiac.demo.domain.models.misc.Wind

class WindMapper : BaseMapper<WindDTO, Wind> {
    override fun mapFrom(from: WindDTO): Wind {
        return Wind(
            deg = from.deg ?: 0,
            speed = from.speed ?: 0.0
        )
    }

    override fun mapFrom(from: List<WindDTO>): List<Wind> {
        return from.map { mapFrom(it) }
    }
}