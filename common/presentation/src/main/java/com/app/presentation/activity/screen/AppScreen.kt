package com.app.presentation.activity.screen

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.app.presentation.compose.ComposeCircularProgress
import com.app.presentation.loader.ProgressDialog
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

interface AppScreen<VM : AppViewModel> {
    val vm: VM
    val host: ScreenHost

    @Composable
    fun Content()

    fun activity() = host.activity
    fun context(): Context = host.activity.baseContext

    fun navigate(route: ScreenRoute) {
        host.navigate(route)
    }

    fun navigate(route: String) {
        host.navigate(route)
    }

    @Composable
    fun ShowLoaderProgress() {
        if (!vm.toggleLoading.value) return
        ComposeCircularProgress().Content()
    }
}