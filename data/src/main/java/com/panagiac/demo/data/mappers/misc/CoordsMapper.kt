package com.panagiac.demo.data.mappers.misc

import com.panagiac.demo.data.mappers.BaseMapper
import com.panagiac.demo.data.models.misc.CoordDTO
import com.panagiac.demo.domain.models.misc.Coord

class CoordsMapper : BaseMapper<CoordDTO, Coord> {
    override fun mapFrom(from: CoordDTO): Coord {
        return Coord(
            lat = from.lat ?: 0.0,
            lon = from.lon ?: 0.0
        )
    }

    override fun mapFrom(from: List<CoordDTO>): List<Coord> {
        return from.map { mapFrom(it) }
    }
}