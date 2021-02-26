package com.panagiac.demo.data.mappers.misc

import com.panagiac.demo.data.mappers.BaseMapper
import com.panagiac.demo.data.models.misc.CoordDTO
import com.panagiac.demo.domain.models.misc.Coord

class CoordsMapper : BaseMapper<CoordDTO, Coord> {
    override fun mapFrom(from: CoordDTO): Coord {
        return Coord(
            lat = from.lat,
            lon = from.lon
        )
    }

    override fun mapFrom(from: List<CoordDTO>): List<Coord> {
        return from.map { mapFrom(it) }
    }
}