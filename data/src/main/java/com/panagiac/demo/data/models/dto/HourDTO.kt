package com.panagiac.demo.data.models.dto

data class HourDTO(
    val clouds: CloudsDTO?,
    val dt: Int?,
    val dt_txt: String?,
    val main: MainDTO?,
    val pop: Double?,
    val sys: SysDTO?,
    val visibility: Int?,
    val weather: List<WeatherItemDTO>?,
    val wind: WindDTO?
)