package com.example.retrofitdemowithcoroutine.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemowithcoroutine.R
import com.example.retrofitdemowithcoroutine.model.ListData

class ListAdapter(private val context: Context, private var listData: ArrayList<ListData>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val id: TextView = itemView.findViewById(R.id.tvNumber)
        val title: TextView = itemView.findViewById(R.id.tvTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentPosition = listData[position]
        holder.id.text = currentPosition.id.toString()
        holder.title.text = currentPosition.title

    }

    fun setData(itemList: ArrayList<ListData>) {
        this.listData = itemList
        notifyDataSetChanged()
    }
}