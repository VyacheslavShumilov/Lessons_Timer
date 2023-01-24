package com.vshum.lessonstimer.data

/** сущность домашней работы */
data class HomeWork(

    /** Название урока */
    val name: String,

    /** Описание домашней работы */
    val description: String,

    /** Дата сдачи домашней работы */
    val date: Long
)
