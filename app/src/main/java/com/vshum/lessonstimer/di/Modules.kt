package com.vshum.lessonstimer.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.vshum.lessonstimer.MainActivity
import com.vshum.lessonstimer.data.repositories.ClassesRepository
import com.vshum.lessonstimer.data.repositories.MockClassesRepository
import com.vshum.lessonstimer.windows.classes.ClassesFragment
import com.vshum.lessonstimer.windows.classes.ClassesViewModel
import com.vshum.lessonstimer.windows.home.HomeFragment
import com.vshum.lessonstimer.windows.home.HomeService
import com.vshum.lessonstimer.windows.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object Modules {
    //модуль, содержимое которого должно быть во всем приложении
    val application = module {
        //навигация
        single<Cicerone<Router>>(qualifier = named(Scopes.CICERONE)) {
            Cicerone.create(Router())
        }
        single<NavigatorHolder>(qualifier = named(Scopes.NAVIGATOR_TAB)) {
            get<Cicerone<Router>>(qualifier = named(Scopes.CICERONE)).getNavigatorHolder()
        }
        single<Router>(qualifier = named(Scopes.ROUTER)) {
            get<Cicerone<Router>>(qualifier = named(Scopes.CICERONE)).router
        }

        single<ClassesRepository>(qualifier = named(Scopes.REPOSITORY)) {
            MockClassesRepository()
        }
    }

    //модуль вкладок
    val bottomNavigationWindow = module {
        scope<MainActivity> {
        }
    }

    //модуль основного экрана
    val homeWindow = module {
        scope<HomeFragment> {
            viewModel(qualifier = named(Scopes.HOME_VIEW_MODEL)) {
                HomeViewModel(get(qualifier = named(Scopes.HOME_SERVICE)))
            }

            scoped<HomeService>(qualifier = named(Scopes.HOME_SERVICE)) {
                HomeService(get(qualifier = named(Scopes.REPOSITORY)))
            }
        }
    }

    //модуль основного экрана
    val classesWindow = module {
        scope<ClassesFragment> {
            viewModel(qualifier = named(Scopes.CLASSES_VIEW_MODEL)) {
                ClassesViewModel(get(qualifier = named(Scopes.HOME_SERVICE)))
            }

            scoped<HomeService>(qualifier = named(Scopes.HOME_SERVICE)) {
                HomeService(get(qualifier = named(Scopes.REPOSITORY)))
            }
        }
    }
}