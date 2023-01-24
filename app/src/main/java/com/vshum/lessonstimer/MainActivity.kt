package com.vshum.lessonstimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.vshum.lessonstimer.databinding.ActivityMainBinding
import com.vshum.lessonstimer.di.Scopes
import com.vshum.lessonstimer.navigation.ClassesScreen
import com.vshum.lessonstimer.navigation.HomeScreen
import com.vshum.lessonstimer.navigation.ListScreen
import com.vshum.lessonstimer.navigation.TagScreen
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent

class MainActivity : AppCompatActivity() {

    private val scope = KoinJavaComponent.getKoin().createScope<MainActivity>()
    private var navigatorHolder: NavigatorHolder =
        scope.get(qualifier = named(Scopes.NAVIGATOR_TAB))
    private val router: Router = scope.get(qualifier = named(Scopes.ROUTER))
    private val navigator = AppNavigator(this, R.id.bottom_container)

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        router.newRootScreen(HomeScreen())
        setBottomClickListener()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    /** Задать обработчик перехода по табам */
    private fun setBottomClickListener() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                //основной экран
                R.id.menu_bottom_home -> {
                    router.newRootScreen(HomeScreen())
                    true
                }

                //уроки
                R.id.menu_bottom_classes -> {
                    router.newRootScreen(ClassesScreen())
                    true
                }

                //Список
                R.id.menu_bottom_list -> {
                    router.newRootScreen(ListScreen())
                    true
                }

                //теги
                R.id.menu_bottom_tag -> {
                    router.newRootScreen(TagScreen())
                    true
                }

                else -> false
            }
        }
    }
}