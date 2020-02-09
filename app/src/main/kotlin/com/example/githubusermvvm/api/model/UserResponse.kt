package com.example.githubusermvvm.api.model

import com.google.gson.annotations.SerializedName

data class UserResponse (
    @SerializedName("results")
    val userList : List<User> = listOf()
)