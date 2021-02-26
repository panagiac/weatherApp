package com.panagiac.demo.data.mappers.misc

import com.panagiac.demo.data.mappers.BaseMapper
import com.panagiac.demo.data.models.misc.SysDTO
import com.panagiac.demo.domain.models.misc.Sys

class SysMapper : BaseMapper<SysDTO, Sys> {
    override fun mapFrom(from: SysDTO): Sys {
        return Sys(
            pod = from.pod
        )
    }

    override fun mapFrom(from: List<SysDTO>): List<Sys> {
        return from.map { mapFrom(it) }
    }
}