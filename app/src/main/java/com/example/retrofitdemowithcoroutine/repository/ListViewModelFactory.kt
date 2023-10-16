package com.example.retrofitdemowithcoroutine.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdemowithcoroutine.viewModel.ListViewModel

class ListViewModelFactory(private val listRepository: ListRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListViewModel(listRepository) as T
    }
}