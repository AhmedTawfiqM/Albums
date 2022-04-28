package com.app.presentation.activity.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController
import com.app.core.domain.albums.model.Album

interface ScreenHost {

    val activity: ComponentActivity
    val navController: NavHostController

    fun navigate(route: String) {
        navController.navigate(route)
    }

    fun navigate(route: ScreenRoute) = navigate(route.route)

    fun putArguments(block: (SavedStateHandle?) -> Unit) {
        navController.currentBackStackEntry?.savedStateHandle.apply {
            block(this)
        }
    }

    fun <T> getArgument(key: String): T? {
        return navController.previousBackStackEntry
            ?.arguments?.getParcelable(key)
    }

    fun popBackStack() {
        navController.popBackStack()
    }
}