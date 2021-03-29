package com.panagiac.demo.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    val icon: String,
    val name: String,
    val main: String,
    val description: String,
    val temp: Int,
    val tempMin: Int,
    val tempMax: Int
): Parcelable