package com.panagiac.demo.weatherapp.extensions

fun <T> List<T>.safeGet(index: Int): T? {
    if (isNotEmpty()) {
        if (lastIndex >= index) {
            return this[index]
        }
    }

    return null
}