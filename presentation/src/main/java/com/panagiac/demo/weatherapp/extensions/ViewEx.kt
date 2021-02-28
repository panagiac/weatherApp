package com.panagiac.demo.weatherapp.extensions

import android.os.Handler
import android.os.Looper
import android.view.View

fun delay(function: () -> Unit, delay: Long = 500L) {
    Looper.myLooper()?.let {
        Handler(it).postDelayed({
            function.invoke()
        }, delay)
    }
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide(delay: Long = 0) {
    delay({ this.visibility = View.GONE }, delay)
}