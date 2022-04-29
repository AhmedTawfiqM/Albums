package com.app.albums.navhost.factory

import androidx.activity.ComponentActivity
import androidx.navigation.NavHostController
import com.app.albums.navhost.AppNavHost

class NavControllerHostFactory(
    private val activity: ComponentActivity,
    private val navController: NavHostController
) {

    fun create(type: NavHostType): AppNavHost {
        return when (type) {
            NavHostType.Albums -> AppNavHost(activity, navController)
        }
    }
}