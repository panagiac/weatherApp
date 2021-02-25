package com.panagiac.demo.weatherapp.extensions

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.InputMethodManager

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

fun View.hideKeyboard() {
    (this.context as? Activity)?.let {
        val imm = it.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.currentFocus?.windowToken, 0)
    }
}