package com.example.githubusermvvm.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.githubusermvvm.api.GithubAPI
import com.example.githubusermvvm.api.model.User
import com.example.githubusermvvm.constant.createRetrofit
import com.example.githubusermvvm.ui.UserListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserListViewModel(adapter: UserListAdapter) : BaseViewModel() {

    private val _items = MutableLiveData<List<User>>()
    private val _adapter = MutableLiveData<UserListAdapter>().apply { value = adapter }
    private val _progressView = MutableLiveData<Int>()

    val items : LiveData<List<User>> get() = _items
    val adapter : LiveData<UserListAdapter> get() = _adapter
    val progressView : LiveData<Int> get() = _progressView

    init{
        loadData()
    }

    private fun loadData(){
        addDisposable(
            createRetrofit(GithubAPI::class.java).getUserList("10")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { showProgress() }
                .doOnTerminate { hideProgress() }
                .subscribe({response ->
                    Log.d("GithubUserMVVM", "Success Load Data")
                    for(user in response.userList){
                        Log.d("GithubUserMVVM",user.fullName + ", " + user.gender + ", " + user.fullLocation)
                    }

                    _items.value = response.userList

                    _adapter.value?.setItems(_items.value!!)

                },{
                    Log.d("GithubUserMVVM", "Fail Load Data")
                })
        )


    }

    private fun showProgress() {
        _progressView.value = View.VISIBLE
    }

    private fun hideProgress() {
        _progressView.value = View.GONE
    }
}