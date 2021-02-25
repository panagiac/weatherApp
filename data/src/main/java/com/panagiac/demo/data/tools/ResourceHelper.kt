package com.panagiac.demo.data.tools

import com.google.gson.Gson
import com.panagiac.demo.data.extensions.asString

object ResourceHelper {
    fun <T> getFile(filename: String, clazz: Class<T>): T? {
        val stream = this.javaClass.classLoader?.getResourceAsStream(filename)
        stream?.let {
            return Gson().fromJson(it.asString(), clazz)
        }

        return null
    }
}