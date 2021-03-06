package com.panagiac.demo.weatherapp.extensions

import androidx.lifecycle.MutableLiveData
import com.panagiac.demo.domain.Response
import com.panagiac.demo.domain.Response.Companion.Status

fun <T> MutableLiveData<Response<T>>.set(
    data: T? = null,
    errorMessage: String? = null,
    status: Status? = null
) {
    this.postValue(
        Response(
            data = data,
            errorMessage = errorMessage,
            responseStatus = status
        )
    )
}