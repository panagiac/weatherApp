package com.panagiac.demo.data.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(): Date? {
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return format.parse(this)
}

fun Date?.toReadableDate(): String {
    val sdf = SimpleDateFormat("dd/MM HH:mm", Locale.getDefault())
    val resultDate = this?.time?.let { Date(it) }

    if (resultDate != null)
        return sdf.format(resultDate)

    return ""
}
