package com.panagiac.demo.weatherapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.panagiac.demo.domain.model.Response.Companion.Status
import com.panagiac.demo.weatherapp.R
import com.panagiac.demo.weatherapp.extensions.build
import com.panagiac.demo.weatherapp.extensions.hide
import com.panagiac.demo.weatherapp.extensions.show
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.toString()
    }

    private val viewModel: MainViewModel by viewModel()

    private lateinit var loadingView: View
    private lateinit var autoCompleteTextView: AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadingView = findViewById(R.id.loading)
        autoCompleteTextView = findViewById(R.id.autoComplete)
    }

    override fun onResume() {
        super.onResume()

        viewModel.getCities().observe(this, { it ->
            when (it.responseStatus) {
                Status.SUCCESSFUL -> {
                    it.data?.let { cityList ->
                        autoCompleteTextView.build(cityList) {
                            viewModel.weather(it)
                        }
                        loadingView.hide()
                    }
                }
                Status.ERROR -> {
                    loadingView.hide()
                }
                Status.LOADING -> {
                    loadingView.show()
                }
            }
        })

        viewModel.getForecast().observe(this, {
            when (it.responseStatus) {
                Status.SUCCESSFUL -> {
                    Log.d(TAG, "Successful")

                    loadingView.hide()
                }
                Status.ERROR -> {
                    loadingView.hide()
                }
                Status.LOADING -> {
                    loadingView.show()
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()

        viewModel.getCities().removeObservers(this)
        viewModel.getForecast().removeObservers(this)
    }
}