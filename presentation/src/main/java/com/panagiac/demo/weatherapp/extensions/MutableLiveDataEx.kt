package com.panagiac.demo.weatherapp.extensions

import androidx.lifecycle.MutableLiveData
import com.panagiac.demo.domain.model.Response
import com.panagiac.demo.domain.model.Response.Companion.Status

fun <T> MutableLiveData<Response<T>>.set(
    data: T? = null,
    status: Status? = null
) {
    this.postValue(
        Response(
            data = data,
            responseStatus = status
        )
    )
}