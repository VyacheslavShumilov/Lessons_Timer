package com.vshum.lessonstimer.windows.home

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.vshum.lessonstimer.data.Classes
import com.vshum.lessonstimer.databinding.ItemClassBinding
import com.vshum.lessonstimer.extensions.toDDMMYYY
import java.util.*

class HomeClassesViewHolder(private val binding: ItemClassBinding,
                            private val listener: ClassesAdapterListener): RecyclerView.ViewHolder(binding.root) {

    /** Отобразить данные по уроку */
    fun setData(classes: Classes) {
        with(binding) {
            classTitle.text = classes.name
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = classes.date
            val description = "${calendar.toDDMMYYY()} ${classes.classNumber}"
            classDescription.text = description

            zoomBlock.isVisible = classes.zoomUrl != null
            zoomBlock.setOnClickListener { listener.buttonZoomClick(classes.zoomUrl) }
        }
    }
}