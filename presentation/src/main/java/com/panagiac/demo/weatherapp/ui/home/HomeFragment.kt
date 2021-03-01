package com.panagiac.demo.weatherapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.panagiac.demo.domain.models.Response.Companion.Status
import com.panagiac.demo.domain.models.Weather
import com.panagiac.demo.weatherapp.R
import com.panagiac.demo.weatherapp.extensions.*
import com.panagiac.demo.weatherapp.ui.detail.DetailFragment
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    companion object {
        @Suppress("unused")
        private val TAG = HomeFragment::class.java.toString()

        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModel()

    private lateinit var resultView: View
    private lateinit var resultLoadingView: View

    private lateinit var autoCompleteView: AutoCompleteTextView
    private lateinit var autoCompleteLoadingView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        resultView = view.findViewById(R.id.result)
        resultView.setOnClickListener {
            viewModel.selectedWeather?.let {
                activity?.navigate(DetailFragment.newInstance(it))
            }
        }
        resultLoadingView = view.findViewById(R.id.resultLoading)

        autoCompleteView = view.findViewById(R.id.autoComplete)
        autoCompleteLoadingView = view.findViewById(R.id.autoCompleteLoading)

        return view
    }

    override fun onResume() {
        super.onResume()

        viewModel.getCities().observe(viewLifecycleOwner, { it ->
            when (it.responseStatus) {
                Status.SUCCESSFUL -> {
                    it.data?.let { cityList ->
                        autoCompleteView.build(cityList) {
                            viewModel.weather(it)
                        }
                        autoCompleteLoadingView.hide()
                        resultLoadingView.hide()
                    }
                }
                Status.ERROR -> {
                    it.errorMessage?.let { message -> activity?.toast(message) }

                    autoCompleteLoadingView.show()
                    resultLoadingView.hide()
                }
                Status.LOADING -> {
                    autoCompleteLoadingView.show()
                    resultLoadingView.show()
                }
            }
        })

        viewModel.getWeather().observe(viewLifecycleOwner, {
            when (it.responseStatus) {
                Status.SUCCESSFUL -> {
                    it.data?.let { weather ->
                        loadResult(weather)

                        resultLoadingView.hide()
                        autoCompleteLoadingView.hide()
                    }
                }
                Status.ERROR -> {
                    it.errorMessage?.let { message -> activity?.toast(message) }

                    resultView.hide()
                    resultLoadingView.hide()
                    autoCompleteLoadingView.hide()
                }
                Status.LOADING -> {
                    resultView.hide()
                    resultLoadingView.show()
                    autoCompleteLoadingView.show()
                }
            }
        })
    }

    private fun loadResult(weather: Weather) {
        this.view?.findViewById<ImageView>(R.id.weatherIcon)
            ?.loadImage(weather.weather.safeGet(0)?.icon)
        this.view?.findViewById<TextView>(R.id.cityName)?.text = weather.name
        this.view?.findViewById<TextView>(R.id.main)?.text = weather.weather.safeGet(0)?.main
        this.view?.findViewById<TextView>(R.id.description)?.text =
            weather.weather.safeGet(0)?.description

        this.view?.findViewById<TextView>(R.id.temp)?.text =
            getString(R.string.temperature, weather.main.temp)
        this.view?.findViewById<TextView>(R.id.tempMin)?.text =
            getString(R.string.tempMin, weather.main.tempMin)
        this.view?.findViewById<TextView>(R.id.tempMax)?.text =
            getString(R.string.tempMax, weather.main.tempMax)

        resultView.show()
    }

    override fun onPause() {
        super.onPause()

        viewModel.getCities().removeObservers(viewLifecycleOwner)
        viewModel.getWeather().removeObservers(viewLifecycleOwner)
    }
}