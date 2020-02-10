package com.example.githubusermvvm.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User (
    @SerializedName("gender")
    var gender: String?,

    @SerializedName("name")
    var name: Name?,

    @SerializedName("location")
    var location: Location?
) : Serializable{
    val fullName : String
        get() = name?.title + "." + name?.first + "." + name?.last

    val fullLocation : String
        get() = location?.state + "," + location?.city + "," + location?.postcode
}