package com.app.presentation.activity.screen

import androidx.compose.runtime.Composable
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
interface AppScreen<VM : AppViewModel> {

    val vm: VM
    val host: ScreenHost

    fun activity() = host.activity

    @Composable
    fun Content()
}