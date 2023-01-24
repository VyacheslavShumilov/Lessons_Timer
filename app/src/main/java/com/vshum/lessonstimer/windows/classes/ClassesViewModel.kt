package com.vshum.lessonstimer.windows.classes

import com.vshum.lessonstimer.base.BaseViewModel
import kotlinx.coroutines.launch
import com.vshum.lessonstimer.windows.home.HomeService

class ClassesViewModel(private val service: HomeService) : BaseViewModel<ClassesState>() {

    /** Получить список уроков */
    fun getClasses() {
        coroutineScope.launch {
            liveData.postValue(ClassesState.ClassesList(service.getClasses()))
        }
    }
}