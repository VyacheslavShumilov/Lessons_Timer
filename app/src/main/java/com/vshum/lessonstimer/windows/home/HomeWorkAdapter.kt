package com.vshum.lessonstimer.windows.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vshum.lessonstimer.data.HomeWork
import com.vshum.lessonstimer.databinding.ItemHomeworkBinding
import com.vshum.lessonstimer.windows.home.HomeWorkViewHolder

class  HomeWorkAdapter(private val items: List<HomeWork>): RecyclerView.Adapter<HomeWorkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeWorkViewHolder {
        val binding = ItemHomeworkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeWorkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeWorkViewHolder, position: Int) {
        holder.setData(items[position])
    }

    override fun getItemCount() = items.size
}