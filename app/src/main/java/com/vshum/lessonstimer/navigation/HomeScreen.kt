package com.vshum.lessonstimer.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.vshum.lessonstimer.windows.home.HomeFragment

class HomeScreen(): FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment = HomeFragment()
}