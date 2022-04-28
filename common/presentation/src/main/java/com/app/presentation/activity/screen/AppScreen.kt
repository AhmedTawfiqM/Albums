package com.app.presentation.activity.screen

import androidx.compose.runtime.Composable
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
interface AppScreen<VM : AppViewModel> {
    val vm: VM
    val host: ScreenHost

    @Composable
    fun Content()

    fun activity() = host.activity
    fun context() = host.activity.baseContext

    fun navigate(route: ScreenRoute) {
        host.navigate(route)
    }

    fun navigate(route: String) {
        host.navigate(route)
    }
}