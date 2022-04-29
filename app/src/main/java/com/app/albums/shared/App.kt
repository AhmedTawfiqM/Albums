package com.app.albums.shared

import com.app.presentation.app.CoreApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : CoreApp() {

    override fun onCreate() {
        super.onCreate()
        context = this
        setup()
    }

    private fun setup() {
    }
}
