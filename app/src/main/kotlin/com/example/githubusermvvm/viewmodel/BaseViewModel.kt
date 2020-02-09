package com.example.githubusermvvm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {
    private val compositeDisPosable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisPosable.add(disposable)
    }

    override fun onCleared() {
        compositeDisPosable.clear()
        Log.d("GithubUserMVVM", "onCleared")
        super.onCleared()
    }
}