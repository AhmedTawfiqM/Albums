package com.app.presentation.activity.screen

import androidx.compose.runtime.Composable
import com.app.presentation.viewmodel.AppViewModel

interface AppScreen<VM : AppViewModel> {
    val vm: AppViewModel

    @Composable
    fun Content()
}