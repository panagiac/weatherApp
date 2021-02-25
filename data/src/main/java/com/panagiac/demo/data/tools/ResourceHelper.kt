package com.panagiac.demo.data.tools

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

object ResourceHelper {
    fun <T> getFile(filename: String, clazz: Class<T>): T? {
        val stream = this.javaClass.classLoader?.getResourceAsStream(filename)
        val reader = BufferedReader(InputStreamReader(stream))

        stream?.let {
            return Gson().fromJson(reader, clazz)
        }

        return null
    }
}