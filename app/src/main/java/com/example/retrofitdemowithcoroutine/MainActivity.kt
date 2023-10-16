package com.example.retrofitdemowithcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListAdapter
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemowithcoroutine.model.ListData
import com.example.retrofitdemowithcoroutine.repository.ListRepository
import com.example.retrofitdemowithcoroutine.repository.ListViewModelFactory
import com.example.retrofitdemowithcoroutine.viewModel.ListViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerview: RecyclerView
    lateinit var listAdapter: com.example.retrofitdemowithcoroutine.adapter.ListAdapter
    lateinit var listViewModel: ListViewModel
    lateinit var progressBAr: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBAr = findViewById(R.id.progressBar)
        initRecyclerView()
        val listRepository = ListRepository()
        val viewModelFactory = ListViewModelFactory(listRepository)
        listViewModel = ViewModelProvider(this, viewModelFactory)[ListViewModel::class.java]
        listViewModel.getData()
        listViewModel.listMutableLiveData.observe(this, Observer {
            listAdapter.setData(it as ArrayList<ListData>)
            progressBAr.visibility = View.VISIBLE
            recyclerview.visibility = View.VISIBLE
        })
    }

    private fun initRecyclerView() {
        recyclerview = findViewById(R.id.recyclerView)
        listAdapter = com.example.retrofitdemowithcoroutine.adapter.ListAdapter(this, ArrayList())
        recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
    }
}