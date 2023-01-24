package com.vshum.lessonstimer.windows.home

import com.vshum.lessonstimer.data.Classes
import com.vshum.lessonstimer.data.HomeWork
import com.vshum.lessonstimer.data.Tee

sealed class HomeState {
    data class TimeToExam(val time: Tee<Long, Long, Long>): HomeState()

    data class ClassesList(val classes: List<Classes>,
                           val currentClass: Int,
                           val countClasses: String): HomeState()

    data class HomeWorkList(val homework: List<HomeWork>): HomeState()
}
