package com.panagiac.demo.domain.models.misc

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hour(
    val dt: Int,
    val dtText: String,
    val main: Main,
    val pop: Int,
    val visibility: Int,
    val weatherItem: List<WeatherItem>
) : Parcelable