@file:Suppress("unused")

package com.panagiac.demo.data.mapper

import io.reactivex.Single

abstract class BaseMapper<in T, E> {
    abstract fun mapFrom(from: T): E
    abstract fun mapFrom(from: List<T>): List<E>

    fun toSingle(from: T): Single<E> = Single.fromCallable { mapFrom(from) }
    fun toSingle(from: List<T>): Single<List<E>> =
        Single.fromCallable { from.map { mapFrom(it) } }
}