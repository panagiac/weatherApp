package com.panagiac.demo.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val country: String,
    val name: String,
) : Parcelable