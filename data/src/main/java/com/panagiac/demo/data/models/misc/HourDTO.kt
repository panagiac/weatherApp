package com.panagiac.demo.data.models.misc

data class HourDTO(
    val clouds: CloudsDTO,
    val dt: Int,
    val dt_txt: String,
    val main: MainDTO,
    val pop: Int,
    val sys: SysDTO,
    val visibility: Int,
    val weatherItem: List<WeatherItemDTO>,
    val wind: WindDTO
)