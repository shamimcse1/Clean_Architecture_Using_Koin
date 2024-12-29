package com.codercamp.cleanarchitecturemvvm.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin with your modules
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)  // Your Koin modules
        }
    }
}