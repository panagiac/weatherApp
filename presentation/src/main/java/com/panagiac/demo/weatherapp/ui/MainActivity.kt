package com.panagiac.demo.weatherapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.panagiac.demo.weatherapp.R
import com.panagiac.demo.weatherapp.extensions.replace
import com.panagiac.demo.weatherapp.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    companion object {
        @Suppress("unused")
        private val TAG = MainActivity::class.java.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            replace(HomeFragment.newInstance())
        }
    }

    override fun onBackPressed() {
        if (!supportFragmentManager.popBackStackImmediate()) {
            finishAfterTransition()
        }
    }
}