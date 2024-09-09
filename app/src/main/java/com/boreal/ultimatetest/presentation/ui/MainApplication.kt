package com.boreal.ultimatetest.presentation.ui

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {

    companion object {
        var instance: MainApplication? = null
        private var appContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appContext = applicationContext
    }

}