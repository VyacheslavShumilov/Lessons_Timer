package com.vshum.lessonstimer.data.repositories

import com.vshum.lessonstimer.data.Classes
import com.vshum.lessonstimer.data.HomeWork

interface ClassesRepository {

    /** Получить дату экзамена */
    fun getExamDate(): Long

    /** Получить список уроков */
    fun getClasses(): List<Classes>

    /** Получить список домашних работ */
    fun getHomeWork(): List<HomeWork>
}