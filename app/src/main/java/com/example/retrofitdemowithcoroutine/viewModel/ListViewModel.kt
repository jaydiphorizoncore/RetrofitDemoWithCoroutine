package com.example.retrofitdemowithcoroutine.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitdemowithcoroutine.model.ListData
import com.example.retrofitdemowithcoroutine.repository.ListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(private val listRepository: ListRepository) : ViewModel() {

    val listMutableLiveData: MutableLiveData<List<ListData>> = MutableLiveData()

    fun getData() {
        CoroutineScope(Dispatchers.Main).launch {

            val response = listRepository.getData()
            listMutableLiveData.value = response

           // Log.e("TAG", "getData: ${message} ")

        }
    }
}