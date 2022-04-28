package com.app.presentation.activity.screen

import androidx.activity.ComponentActivity
import androidx.navigation.NavHostController
import com.app.presentation.viewmodel.AppViewModel

interface ScreenHost {

    val activity: ComponentActivity
    val navController: NavHostController

    fun navigate(route: ScreenRoute) {
        navController.navigate(route.route)
    }

    fun popBackStack() {
        navController.popBackStack()
    }
}