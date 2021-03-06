package com.panagiac.demo.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val country: String,
    val name: String,
) : Parcelable