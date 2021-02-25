package com.panagiac.demo.data.extensions

import java.io.InputStream
import java.io.InputStreamReader
import java.io.StringWriter

fun InputStream.asString(): String {
    var n: Int
    val buffer = CharArray(1024 * 4)
    val reader = InputStreamReader(this, "UTF8")
    val writer = StringWriter()
    while (-1 != reader.read(buffer).also { n = it }) writer.write(buffer, 0, n)
    return writer.toString()
}