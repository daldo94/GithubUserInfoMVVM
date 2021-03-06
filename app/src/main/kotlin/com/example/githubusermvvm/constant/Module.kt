package com.example.githubusermvvm.constant

import com.example.githubusermvvm.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun <T> createRetrofit(service : Class<T>) : T = defaultRetrofit().create(service)

private fun defaultRetrofit() : Retrofit =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(createOkHttpClient())
        .build()


private fun createOkHttpClient() : OkHttpClient{
    val interceptor = HttpLoggingInterceptor()
    if(BuildConfig.DEBUG){
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    }else{
        interceptor.level = HttpLoggingInterceptor.Level.NONE
    }

    return OkHttpClient.Builder()
        .addNetworkInterceptor(interceptor)
        .build()
}



