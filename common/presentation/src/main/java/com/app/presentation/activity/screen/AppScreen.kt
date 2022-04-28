package com.app.presentation.activity.screen

import androidx.compose.runtime.Composable
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
interface AppScreen<vm : AppViewModel> : ScreenHost {

    val vm: AppViewModel

    @Composable
    fun Content()
}