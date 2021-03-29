package com.panagiac.demo.weatherapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.panagiac.demo.domain.Response.Companion.Status
import com.panagiac.demo.weatherapp.R
import com.panagiac.demo.weatherapp.databinding.FragmentHomeBinding
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

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.result.root.setOnClickListener {
            viewModel.selectedWeather?.let {
                activity?.navigate(DetailFragment.newInstance(it))
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCities().observe(viewLifecycleOwner, { it ->
            when (it.responseStatus) {
                Status.SUCCESSFUL -> {
                    it.data?.let { cityList ->
                        binding.autoComplete.build(cityList) {
                            viewModel.weather(it)
                        }
                        binding.autoCompleteLoading.hide()
                        binding.resultLoading.hide()
                    }
                }
                Status.ERROR -> {
                    it.errorMessage?.let { message -> activity?.toast(message) }

                    binding.autoCompleteLoading.show()
                    binding.resultLoading.hide()
                }
                Status.LOADING -> {
                    binding.autoCompleteLoading.show()
                    binding.resultLoading.show()
                }
            }
        })

        viewModel.getWeather().observe(viewLifecycleOwner, {
            when (it.responseStatus) {
                Status.SUCCESSFUL -> {
                    it.data?.let { weather ->
                        binding.result.weatherIcon.loadImage(weather.icon)
                        binding.result.cityName.text = weather.name
                        binding.result.main.text = weather.main
                        binding.result.description.text = weather.description
                        binding.result.temp.text = getString(R.string.temperature, weather.temp)
                        binding.result.tempMin.text = getString(R.string.tempMin, weather.tempMin)
                        binding.result.tempMax.text = getString(R.string.tempMax, weather.tempMax)

                        binding.result.root.show()
                        binding.resultLoading.hide()
                        binding.autoCompleteLoading.hide()
                    }
                }
                Status.ERROR -> {
                    it.errorMessage?.let { message -> activity?.toast(message) }

                    binding.result.root.hide()
                    binding.resultLoading.hide()
                    binding.autoCompleteLoading.hide()
                }
                Status.LOADING -> {
                    binding.result.root.hide()
                    binding.resultLoading.show()
                    binding.autoCompleteLoading.show()
                }
            }
        })
    }
}