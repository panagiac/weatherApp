package com.panagiac.demo.weatherapp.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.panagiac.demo.domain.models.Forecast
import com.panagiac.demo.domain.models.misc.Hour
import com.panagiac.demo.weatherapp.R
import com.panagiac.demo.weatherapp.extensions.loadImage
import org.koin.core.KoinComponent
import org.koin.core.get

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.ViewHolder>(), KoinComponent {

    private val hourList: MutableList<Hour> = mutableListOf()
    private val context: Context = get()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val temp: TextView = view.findViewById(R.id.temp)
        val date: TextView = view.findViewById(R.id.date)
        val imageView: ImageView = view.findViewById(R.id.weatherIcon)
    }

    override fun getItemId(position: Int): Long {
        return hourList[position].dt.toLong()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater
                .from(viewGroup.context)
                .inflate(R.layout.item_detail, viewGroup, false)

        return ViewHolder(view)
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