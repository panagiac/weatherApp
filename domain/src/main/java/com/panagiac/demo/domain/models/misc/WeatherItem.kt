package com.panagiac.demo.domain.models.misc

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherItem(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
): Parcelable