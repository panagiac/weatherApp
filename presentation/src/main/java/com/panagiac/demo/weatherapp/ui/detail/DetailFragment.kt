package com.panagiac.demo.weatherapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.panagiac.demo.domain.Response.Companion.Status
import com.panagiac.demo.domain.models.Weather
import com.panagiac.demo.weatherapp.databinding.FragmentDetailBinding
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
    private lateinit var binding: FragmentDetailBinding
    private lateinit var detailAdapter: DetailAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)

        arguments?.let { safeArguments ->
            val weather = safeArguments.getParcelable<Weather>(KEY)
            weather?.let {
                binding.cityName.text = weather.name
                viewModel.forecast(it.name)
            }
        }

        detailAdapter = DetailAdapter()

        binding.recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = LinearLayoutManager(context)
            adapter = detailAdapter.apply {
                setHasStableIds(true)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getForecast().observe(viewLifecycleOwner, {
            when (it.responseStatus) {
                Status.SUCCESSFUL -> {
                    it.data?.let { forecast -> detailAdapter.addForecast(forecast) }
                    binding.loading.root.hide()
                }
                Status.ERROR -> {
                    it.errorMessage?.let { message -> activity?.toast(message) }

                    binding.loading.root.hide()
                }
                Status.LOADING -> {
                    binding.loading.root.show()
                }
            }
        })
    }
}