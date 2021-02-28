package com.panagiac.demo.data.extensions

fun Double.toCelsius(): Double {
    return if (this > 0.0) {
        this - 273.15f
    } else {
        0.0
    }
}