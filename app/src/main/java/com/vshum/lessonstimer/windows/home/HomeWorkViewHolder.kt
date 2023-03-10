package com.vshum.lessonstimer.windows.home

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.vshum.lessonstimer.R
import com.vshum.lessonstimer.data.HomeWork
import com.vshum.lessonstimer.databinding.ItemHomeworkBinding
import com.vshum.lessonstimer.extensions.getDifferenceDate
import java.util.*

class HomeWorkViewHolder(private val binding: ItemHomeworkBinding): RecyclerView.ViewHolder(binding.root) {

    init {
        val PROC_WIDTH = 0.7 //ширина карточки 70% от ширины экрана
        val display = itemView.context.resources.displayMetrics
        val cardWidth = (display.widthPixels * PROC_WIDTH).toInt()

        val layoutParams = binding.root.layoutParams
        layoutParams.width = cardWidth
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
    }

    /** Отобразить данные по домашней работе */
    fun setData(homework: HomeWork) {
        with(binding) {
            homeworkTitle.text = homework.name
            homeworkDescription.text = homework.description

            //формируем дату
            val context = binding.root.context
            val res = context.resources
            val color: Int
            val dateText: String
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = homework.date
            val countDay = calendar.getDifferenceDate().first
            if (System.currentTimeMillis() > homework.date) {
                color = ContextCompat.getColor(context, R.color.error_text_color)
                dateText = res.getQuantityString(R.plurals.expire_homework_timer, countDay.toInt(), countDay)
            }
            else {
                color = ContextCompat.getColor(context, R.color.secondary_text_color2)
                dateText = res.getQuantityString(R.plurals.homework_timer, countDay.toInt(), countDay)
            }

            homeworkIcon.setBackgroundColor(color)
            homeworkDate.setTextColor(color)
            homeworkDate.text = dateText
        }
    }
}