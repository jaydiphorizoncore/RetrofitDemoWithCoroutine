package com.example.retrofitdemowithcoroutine.repository

import com.example.retrofitdemowithcoroutine.model.ListData
import com.example.retrofitdemowithcoroutine.network.RetrofitBuilder

class ListRepository {

     suspend fun getData(): List<ListData> = RetrofitBuilder.listInterface.getDAta()
}