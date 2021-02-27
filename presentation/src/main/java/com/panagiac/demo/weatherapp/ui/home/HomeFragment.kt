package com.panagiac.demo.weatherapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.panagiac.demo.domain.models.Response
import com.panagiac.demo.weatherapp.R
import com.panagiac.demo.weatherapp.extensions.build
import com.panagiac.demo.weatherapp.extensions.hide
import com.panagiac.demo.weatherapp.extensions.show
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    companion object {
        private val TAG = HomeFragment::class.java.toString()

        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModel()

    private lateinit var loadingView: View
    private lateinit var autoCompleteTextView: AutoCompleteTextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        loadingView = view.findViewById(R.id.loading)
        autoCompleteTextView = view.findViewById(R.id.autoComplete)

        return view
    }

    override fun onResume() {
        super.onResume()

        viewModel.getCities().observe(viewLifecycleOwner, { it ->
            when (it.responseStatus) {
                Response.Companion.Status.SUCCESSFUL -> {
                    it.data?.let { cityList ->
                        autoCompleteTextView.build(cityList) {
                            viewModel.weather(it)
                        }
                        loadingView.hide()
                    }
                }
                Response.Companion.Status.ERROR -> {
                    loadingView.hide()
                }
                Response.Companion.Status.LOADING -> {
                    loadingView.show()
                }
            }
        })

        viewModel.getWeather().observe(viewLifecycleOwner, {
            when (it.responseStatus) {
                Response.Companion.Status.SUCCESSFUL -> {
                    Log.d(TAG, "Successful")

                    loadingView.hide()
                }
                Response.Companion.Status.ERROR -> {
                    loadingView.hide()
                }
                Response.Companion.Status.LOADING -> {
                    loadingView.show()
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()

        viewModel.getCities().removeObservers(this)
        viewModel.getWeather().removeObservers(this)
    }
}