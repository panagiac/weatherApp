package com.panagiac.demo.data.models.dto

data class ForecastDTO(
    val city: CityDTO?,
    val cnt: Int?,
    val cod: String?,
    val list: List<HourDTO>?,
    val message: Int?
)











