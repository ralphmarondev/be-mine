package com.ralphmarondev.bemine

import android.app.Application
import com.ralphmarondev.bemine.core.preferences.AppPreferences

class MyApp : Application() {
    companion object {
        lateinit var preferences: AppPreferences
            private set
    }

    override fun onCreate() {
        super.onCreate()

        preferences = AppPreferences(applicationContext)
    }
}