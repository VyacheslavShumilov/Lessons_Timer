package com.vshum.lessonstimer.windows.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vshum.lessonstimer.data.Classes
import com.vshum.lessonstimer.databinding.ItemClassListBinding
import com.vshum.lessonstimer.windows.home.ClassesAdapterListener

class  ClassesAdapter(private val items: List<Classes>,
                      private val listener: ClassesAdapterListener
): RecyclerView.Adapter<ClassesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        val binding = ItemClassListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClassesViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        holder.setData(items[position])
    }

    override fun getItemCount() = items.size
}