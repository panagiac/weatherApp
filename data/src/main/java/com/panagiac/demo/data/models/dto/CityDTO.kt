package com.panagiac.demo.data.models.dto

data class CityDTO(
    val coord: CoordDTO?,
    val country: String?,
    val id: Int?,
    val name: String?,
    val population: Int?,
    val sunrise: Int?,
    val sunset: Int?,
    val timezone: Int?
)
