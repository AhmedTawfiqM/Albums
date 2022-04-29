package com.app.presentation

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.annotation.StringRes
import com.app.presentation.app.CoreApp

fun showDebugToast(context: Context = CoreApp.context, value: String) {
    if (!BuildConfig.DEBUG) return
    showToast(context, value)
}

fun showDebugToast(context: Context = CoreApp.context, @StringRes idRes: Int) {
    if (!BuildConfig.DEBUG) return
    showToast(context, idRes)
}

fun showToast(
    context: Context = CoreApp.context,
    value: String,
    duration: Int = Toast.LENGTH_SHORT
) {
    runOnMainThread {
        Toast.makeText(context, value, duration).show()
    }
    Log.d("showToast", value)
}

fun showToast(
    context: Context = CoreApp.context,
    @StringRes idRes: Int,
    duration: Int = Toast.LENGTH_SHORT
) {
    runOnMainThread {
        val msg = context.getString(idRes)
        Toast.makeText(context, msg, duration).show()
        Log.d("showToast", msg)
    }
}

