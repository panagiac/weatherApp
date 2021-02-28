package com.panagiac.demo.weatherapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.panagiac.demo.domain.models.Response.Companion.Status
import com.panagiac.demo.domain.models.Weather
import com.panagiac.demo.weatherapp.R
import com.panagiac.demo.weatherapp.extensions.hide
import com.panagiac.demo.weatherapp.extensions.show
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {
    companion object {
        private val TAG = DetailFragment::class.java.toString()
        private const val KEY = "WEATHER"

        @JvmStatic
        fun newInstance(weather: Weather) = DetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY, weather)
            }
        }
    }

    private val viewModel: DetailViewModel by viewModel()
    private lateinit var loading: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let { safeArguments ->
            val weather = safeArguments.getParcelable<Weather>(KEY)
            weather?.let { viewModel.forecast(it.name) }
        }

        val layout = inflater.inflate(R.layout.fragment_detail, container, false)

        loading = layout.rootView.findViewById(R.id.loading)

        return layout
    }

    override fun onResume() {
        super.onResume()

        viewModel.getForecast().observe(viewLifecycleOwner, {
            when (it.responseStatus) {
                Status.SUCCESSFUL -> {
                    loading.hide()
                }
                Status.ERROR -> {
                    loading.hide()
                }
                Status.LOADING -> {
                    loading.show()
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()

        viewModel.getForecast().removeObservers(viewLifecycleOwner)
    }
}