package com.panagiac.demo.weatherapp.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.panagiac.demo.domain.models.Forecast
import com.panagiac.demo.domain.models.Hour
import com.panagiac.demo.weatherapp.R
import com.panagiac.demo.weatherapp.databinding.ItemDetailBinding
import com.panagiac.demo.weatherapp.extensions.loadImage
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.ViewHolder>(), KoinComponent {
    private val context: Context by inject()

    private val hourList: MutableList<Hour> = mutableListOf()

    class ViewHolder(binding: ItemDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        val temp: TextView = binding.temp
        val date: TextView = binding.date
        val imageView: ImageView = binding.weatherIcon
    }

    override fun getItemId(position: Int): Long {
        return hourList[position].dt.toLong()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDetailBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val hour = hourList[position]

        viewHolder.temp.text = context.getString(R.string.temperature, hour.temp)
        viewHolder.date.text = hour.dtText
        viewHolder.imageView
            .loadImage(
                hour.icon,
                RequestOptions().centerInside()
            )
    }

    fun addForecast(forecast: Forecast) {
        hourList.clear()
        hourList.addAll(forecast.list)

        notifyDataSetChanged()
    }

    override fun getItemCount() = hourList.size
}