package com.panagiac.demo.weatherapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.panagiac.demo.domain.models.Response.Companion.Status
import com.panagiac.demo.weatherapp.R
import com.panagiac.demo.weatherapp.extensions.build
import com.panagiac.demo.weatherapp.extensions.hide
import com.panagiac.demo.weatherapp.extensions.navigate
import com.panagiac.demo.weatherapp.extensions.show
import com.panagiac.demo.weatherapp.ui.detail.DetailFragment
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    companion object {
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
            viewModel.selectedCity?.let {
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
                    resultView.show()
                    resultLoadingView.hide()
                    autoCompleteLoadingView.hide()
                }
                Status.ERROR -> {
                    resultView.show()
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

    override fun onPause() {
        super.onPause()

        viewModel.getCities().removeObservers(viewLifecycleOwner)
        viewModel.getWeather().removeObservers(viewLifecycleOwner)
    }
}