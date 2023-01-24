package com.vshum.lessonstimer.windows.classes

import androidx.recyclerview.widget.RecyclerView

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