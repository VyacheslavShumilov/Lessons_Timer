package com.vshum.lessonstimer.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.ListFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ListScreen(): FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment = ListFragment()
}