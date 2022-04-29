package com.app.presentation.activity.screen

import androidx.activity.ComponentActivity
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController

interface NavControllerHost {
    val activity: ComponentActivity
    val navController: NavHostController

    fun navigate(route: String) {
        navController.navigate(route)
    }

    fun navigate(route: ScreenRoute) = navigate(route.route)

    fun popBackStack() {
        navController.popBackStack()
    }

    fun putArguments(block: (SavedStateHandle?) -> Unit) {
        navController.currentBackStackEntry?.savedStateHandle.apply {
            block(this)
        }
    }

    fun <T> getArgument(key: String): T? {
        return navController.previousBackStackEntry
            ?.arguments?.getParcelable(key)
    }

}