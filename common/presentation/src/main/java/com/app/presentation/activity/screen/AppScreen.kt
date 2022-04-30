package com.app.presentation.activity.screen

import android.content.Context
import androidx.compose.runtime.Composable
import com.app.presentation.compose.ComposeCircularProgress
import com.app.presentation.viewmodel.AppViewModel

abstract class AppScreen<VM : AppViewModel> {
    abstract val vm: VM
    abstract val host: NavControllerHost

    @Composable
    protected abstract fun Content()

    @Composable
    fun ScreenContent(){
        Content()
        ShowLoaderProgress()
    }

    fun activity() = host.activity
    fun context(): Context = host.activity.baseContext

    fun navigate(route: ScreenRoute) = host.navigate(route)
    fun navigate(route: String) = host.navigate(route)

    @Composable
    private fun ShowLoaderProgress() {
        if (!vm.toggleLoading.value) return
        ComposeCircularProgress().Content()
    }
}