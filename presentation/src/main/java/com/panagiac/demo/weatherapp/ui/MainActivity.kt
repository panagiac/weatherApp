package com.panagiac.demo.weatherapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.panagiac.demo.domain.model.Response.Companion.Status
import com.panagiac.demo.weatherapp.R
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.toString()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            viewModel.weather("Orvieto")
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.getForecast().observe(this, {
            when (it.responseStatus) {
                Status.SUCCESSFUL -> {
                    Log.d(TAG, "Successful")
                }
                Status.ERROR -> {
                    Log.d(TAG, "Error")
                }
                Status.LOADING -> {
                    Log.d(TAG, "Loading")
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()

        viewModel.getForecast().removeObservers(this)
    }
}