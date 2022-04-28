package com.app.presentation

import android.os.Handler
import android.os.Looper

fun runOnMainThread(runnable: () -> Unit) {
    Handler(Looper.getMainLooper()).post {
        runnable()
    }
}