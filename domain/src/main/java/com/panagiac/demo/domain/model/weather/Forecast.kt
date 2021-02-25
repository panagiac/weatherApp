package com.panagiac.demo.domain.model.weather

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Forecast(
    val cnt: Int,
    val cod: String,
    val message: Int,
    val list: List<Day>,
    var name: String
) : Parcelable