package com.example.githubusermvvm.viewmodel

import android.util.Log
import com.example.githubusermvvm.api.GithubAPI
import com.example.githubusermvvm.constant.createRetrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserListViewModel : BaseViewModel() {

    init{
        loadData()
    }

    private fun loadData(){
        addDisposable(
            createRetrofit(GithubAPI::class.java).getUserList("10")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({response ->
                    Log.d("GithubUserMVVM", "Success Load Data")
                    for(user in response.userList){
                        Log.d("GithubUserMVVM",user.fullName + ", " + user.gender + ", " + user.location)
                    }
                },{
                    Log.d("GithubUserMVVM", "Fail Load Data")
                })
        )


    }
}