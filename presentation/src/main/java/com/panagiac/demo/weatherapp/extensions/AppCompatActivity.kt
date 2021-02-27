package com.panagiac.demo.weatherapp.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.panagiac.demo.weatherapp.R

fun AppCompatActivity.replace(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .replace(R.id.root, fragment)
        .commit()
}

fun AppCompatActivity.navigate(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .add(R.id.root, fragment)
        .addToBackStack(fragment.tag)
        .commit()
}