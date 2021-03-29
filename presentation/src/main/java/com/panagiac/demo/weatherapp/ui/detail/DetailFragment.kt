package com.panagiac.demo.weatherapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panagiac.demo.domain.Response.Companion.Status
import com.panagiac.demo.domain.models.Weather
import com.panagiac.demo.weatherapp.R
import com.panagiac.demo.weatherapp.extensions.hide
import com.panagiac.demo.weatherapp.extensions.show
import com.panagiac.demo.weatherapp.extensions.toast
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {
    companion object {
        @Suppress("unused")
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
    private lateinit var detailAdapter: DetailAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_detail, container, false)

        arguments?.let { safeArguments ->
            val weather = safeArguments.getParcelable<Weather>(KEY)
            weather?.let {
                layout.findViewById<TextView>(R.id.cityName)?.text = weather.name
                viewModel.forecast(it.name)
            }
        }

        loading = layout.rootView.findViewById(R.id.loading)
        detailAdapter = DetailAdapter()

        layout.rootView.findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)

            layoutManager = LinearLayoutManager(context)
            adapter = detailAdapter.apply {
                setHasStableIds(true)
            }
        }

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getForecast().observe(viewLifecycleOwner, {
            when (it.responseStatus) {
                Status.SUCCESSFUL -> {
                    it.data?.let { forecast -> detailAdapter.addForecast(forecast) }
                    loading.hide()
                }
                Status.ERROR -> {
                    it.errorMessage?.let { message -> activity?.toast(message) }

                    loading.hide()
                }
                Status.LOADING -> {
                    loading.show()
                }
            }
        })
    }
}