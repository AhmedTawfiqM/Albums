package com.app.albums.navhost

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.albums.screens.DetailsScreen
import com.app.albums.screens.HomeScreen

class AppNavHost(
    private val navController: NavHostController
) {

    //TODO: make architecture
    @Composable
    fun Setup() {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                HomeScreen().Content()
            }
            composable(Screen.Details.route) {
                DetailsScreen().Content()
            }
        }
    }

    @SuppressLint("ComposableDestinationInComposeScope")
    @Composable
    private fun NavGraphBuilder.ScreenRoute(
        screen: Screen,
        content: @Composable (NavBackStackEntry) -> Unit
    ) {
        this.composable(screen.route) {
            content
        }
    }
}