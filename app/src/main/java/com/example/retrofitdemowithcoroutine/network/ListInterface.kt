package com.example.retrofitdemowithcoroutine.network

import com.example.retrofitdemowithcoroutine.model.ListData
import retrofit2.http.GET

interface ListInterface {

    @GET(value = "posts")
    suspend fun getDAta(): List<ListData>

}