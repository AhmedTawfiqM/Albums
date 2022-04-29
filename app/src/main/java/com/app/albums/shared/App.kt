package com.app.albums.shared

import android.app.Application
import com.app.presentation.app.CoreApp
import dagger.hilt.android.HiltAndroidApp

class App : CoreApp() {

    override fun onCreate() {
        super.onCreate()
        context = this
        setup()
    }

    private fun setup() {
    }
}
@HiltAndroidApp
class MainApp : Application() {
}