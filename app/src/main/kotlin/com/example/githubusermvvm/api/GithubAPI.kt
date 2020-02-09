package com.example.githubusermvvm.api


import com.example.githubusermvvm.api.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubAPI {

    @GET("/")
    fun getUserList(@Query("results") query: String) : Observable<UserResponse>

}