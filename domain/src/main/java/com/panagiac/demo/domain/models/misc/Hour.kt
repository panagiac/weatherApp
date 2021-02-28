package com.panagiac.demo.domain.models.misc

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hour(
    val dt: Int,
    val dtText: String,
    val main: Main,
    val pop: Double,
    val visibility: Int,
    val weather: List<WeatherItem>
) : Parcelable