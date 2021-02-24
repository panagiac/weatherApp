package com.panagiac.demo.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Forecast(
    val cnt: Int,
    val cod: String,
    val message: Int
): Parcelable