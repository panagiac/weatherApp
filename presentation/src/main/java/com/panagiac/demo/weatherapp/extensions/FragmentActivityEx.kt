package com.panagiac.demo.weatherapp.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
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
        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        .setCustomAnimations(
            R.anim.slide_in_from_right,
            R.anim.slide_out_to_left,
            R.anim.slide_in_from_left,
            R.anim.slide_out_to_right
        )
        .add(R.id.root, fragment)
        .addToBackStack(fragment.tag)
        .commit()
}