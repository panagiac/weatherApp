package com.panagiac.demo.data.models

import com.panagiac.demo.data.models.misc.CityDTO
import com.panagiac.demo.data.models.misc.HourDTO

data class ForecastDTO(
    val city: CityDTO?,
    val cnt: Int?,
    val cod: String?,
    val list: List<HourDTO>?,
    val message: Int?
)











