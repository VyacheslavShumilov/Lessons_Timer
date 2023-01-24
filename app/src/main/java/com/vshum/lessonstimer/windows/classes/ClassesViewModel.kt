package com.vshum.lessonstimer.windows.classes

class ClassesViewModel(private val service: HomeService) : BaseViewModel<ClassesState>() {

    /** Получить список уроков */
    fun getClasses() {
        coroutineScope.launch {
            liveData.postValue(ClassesState.ClassesList(service.getClasses()))
        }
    }
}