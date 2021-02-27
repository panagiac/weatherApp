package com.panagiac.demo.weatherapp.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.panagiac.demo.weatherapp.R

fun FragmentActivity.replace(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .replace(R.id.root, fragment)
        .commit()
}

fun FragmentActivity.navigate(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .add(R.id.root, fragment)
        .addToBackStack(fragment.tag)
        .commit()
}