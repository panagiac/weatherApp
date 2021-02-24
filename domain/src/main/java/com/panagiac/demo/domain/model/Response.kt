package com.panagiac.demo.domain.model

data class Response<T>(
    var responseStatus: Status? = null,
    var errorMessage: String? = null,
    var data: T? = null
) {
    companion object {
        enum class Status { SUCCESSFUL, ERROR, LOADING }
    }
}