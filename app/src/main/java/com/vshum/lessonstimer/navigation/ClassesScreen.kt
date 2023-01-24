package com.vshum.lessonstimer.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ClassesScreen(): FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment = ClassesFragment()
}