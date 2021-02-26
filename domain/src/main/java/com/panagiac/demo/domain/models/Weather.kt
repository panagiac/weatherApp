package com.panagiac.demo.domain.models

import android.os.Parcelable
import com.panagiac.demo.domain.models.misc.*
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val visibility: Int,
    val weather: List<WeatherItem>,
    val wind: Wind
): Parcelable