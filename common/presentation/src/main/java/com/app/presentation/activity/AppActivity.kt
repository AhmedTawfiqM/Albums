package com.app.presentation.activity

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable

abstract class AppActivity : ComponentActivity() {

    @Composable
    abstract fun Content()
}