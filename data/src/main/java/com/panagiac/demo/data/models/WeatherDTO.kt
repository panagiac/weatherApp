package com.panagiac.demo.data.models

import com.panagiac.demo.data.models.misc.*

data class WeatherDTO(
    val base: String,
    val clouds: CloudsDTO,
    val cod: Int,
    val coord: CoordDTO,
    val dt: Int,
    val id: Int,
    val main: MainDTO,
    val name: String,
    val sys: SysDTO,
    val visibility: Int,
    val weather: List<WeatherItemDTO>,
    val wind: WindDTO
)