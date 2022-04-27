package com.app.modularApp.shared

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
        setup()
    }

    private fun setup() {
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context

        @JvmStatic
        fun string(@StringRes idRes: Int): String {
            //TODO: check late Initialize
            return context.getString(idRes)
        }
    }

}