package com.panagiac.demo.weatherapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.panagiac.demo.weatherapp.R
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {
    companion object {
        private val TAG = DetailFragment::class.java.toString()
        private const val KEY = "CITY"

        @JvmStatic
        fun newInstance(cityName: String) = DetailFragment().apply {
            arguments = Bundle().apply {
                putString(KEY, cityName)
            }
        }
    }

    private val viewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val cityName = arguments?.getString(KEY, "")
        cityName?.let { viewModel.forecast(it) }

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
}