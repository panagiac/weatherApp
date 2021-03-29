package com.panagiac.demo.domain.models.misc

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hour(
    val temp: Int,
    val dt: Int,
    val dtText: String,
    val icon: String
) : Parcelable