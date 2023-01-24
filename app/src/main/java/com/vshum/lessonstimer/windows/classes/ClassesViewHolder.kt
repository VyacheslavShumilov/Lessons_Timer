package com.vshum.lessonstimer.windows.classes

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.vshum.lessonstimer.data.Classes
import com.vshum.lessonstimer.databinding.ItemClassListBinding
import com.vshum.lessonstimer.extensions.toDDMMYYY
import com.vshum.lessonstimer.windows.home.ClassesAdapterListener
import java.util.*

class ClassesViewHolder(private val binding: ItemClassListBinding,
                        private val listener: ClassesAdapterListener
): RecyclerView.ViewHolder(binding.root) {

    /** Отобразить данные по уроку */
    fun setData(classes: Classes) {
        with(binding) {
            classTitle.text = classes.name
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = classes.date
            val time = "${calendar.toDDMMYYY()} ${classes.classNumber}"
            classTimeTitle.text = time
            classDescription.text = classes.description

            zoomBlock.isVisible = classes.zoomUrl != null
            zoomBlock.setOnClickListener { listener.buttonZoomClick(classes.zoomUrl) }
        }
    }
}