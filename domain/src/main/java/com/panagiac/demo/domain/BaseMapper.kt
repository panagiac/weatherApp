@file:Suppress("unused")

package com.panagiac.demo.domain

import io.reactivex.Single

interface BaseMapper<in T, E> {
    fun mapFrom(from: T): E
    fun mapFrom(from: List<T>): List<E>

    fun toSingle(from: T): Single<E> = Single.fromCallable { mapFrom(from) }
    fun toSingle(from: List<T>): Single<List<E>> = Single.fromCallable { from.map { mapFrom(it) } }
}