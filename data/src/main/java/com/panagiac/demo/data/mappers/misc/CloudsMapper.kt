package com.panagiac.demo.data.mappers.misc

import com.panagiac.demo.data.mappers.BaseMapper
import com.panagiac.demo.data.models.misc.CloudsDTO
import com.panagiac.demo.domain.models.misc.Clouds

class CloudsMapper : BaseMapper<CloudsDTO, Clouds> {
    override fun mapFrom(from: CloudsDTO): Clouds {
        return Clouds(
            all = from.all
        )
    }

    override fun mapFrom(from: List<CloudsDTO>): List<Clouds> {
        return from.map { mapFrom(it) }
    }
}