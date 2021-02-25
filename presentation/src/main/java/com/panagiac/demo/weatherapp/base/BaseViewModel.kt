package com.panagiac.demo.weatherapp.base

import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun <T> doAsync(
        asyncAction: Single<T>,
        onSuccess: (data: T) -> Unit,
        onError: (throwable: Throwable) -> Unit
    ) {
        compositeDisposable.add(
            asyncAction
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        onSuccess(it)
                    },
                    {
                        onError(it)
                    }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
    }
}