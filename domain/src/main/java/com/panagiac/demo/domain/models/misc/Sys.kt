package com.panagiac.demo.domain.models.misc

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sys(
    val pod: String
): Parcelable