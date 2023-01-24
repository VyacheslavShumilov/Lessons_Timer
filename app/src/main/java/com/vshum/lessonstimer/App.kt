package com.vshum.lessonstimer

import android.app.Application
import com.vshum.lessonstimer.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                Modules.application,
                Modules.bottomNavigationWindow,
                Modules.homeWindow,
                Modules.classesWindow,
            )
        }
    }
}