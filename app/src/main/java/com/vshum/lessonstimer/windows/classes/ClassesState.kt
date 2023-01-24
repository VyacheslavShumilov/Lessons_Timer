package com.vshum.lessonstimer.windows.classes

import com.vshum.lessonstimer.data.Classes

sealed class ClassesState {
    data class ClassesList(val classes: List<Classes>): ClassesState()
}
