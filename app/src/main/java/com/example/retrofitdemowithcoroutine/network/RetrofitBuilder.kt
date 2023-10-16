package com.example.retrofitdemowithcoroutine.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val Url = "https://jsonplaceholder.typicode.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val listInterface: ListInterface by lazy {
        retrofit.create(listInterface::class.java)
    }
}