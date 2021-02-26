package com.panagiac.demo.domain.model.weather

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hour(
    val dt: Int,
    val dtText: String,
    val main: Main,
    val pop: Int,
    val visibility: Int,
    val weather: List<Weather>
) : Parcelable