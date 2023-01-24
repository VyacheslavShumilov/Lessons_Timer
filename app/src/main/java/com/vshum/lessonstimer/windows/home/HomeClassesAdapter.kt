package com.vshum.lessonstimer.windows.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class  HomeClassesAdapter(private val items: List<Classes>,
                          private val listener: ClassesAdapterListener):
    RecyclerView.Adapter<HomeClassesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeClassesViewHolder {
        val binding = ItemClassBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeClassesViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: HomeClassesViewHolder, position: Int) {
        holder.setData(items[position])
    }

    override fun getItemCount() = items.size
}