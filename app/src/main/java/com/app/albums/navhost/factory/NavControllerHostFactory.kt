package com.app.albums.navhost.factory

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.albums.navhost.AlbumsNavHost

/**
 * this Factory is responsible to create NavHost
 * Complex App must be Maintainable and Reusable
 **/
class NavControllerHostFactory(
    private val activity: ComponentActivity,
) {

    @Composable
    fun create(
        type: NavHostType,
        navController: NavHostController = rememberNavController()
    ): AlbumsNavHost {
        return when (type) {
            NavHostType.Albums -> AlbumsNavHost(activity, navController)
        }
    }
}