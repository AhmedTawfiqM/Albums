package com.app.albums.navhost

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.albums.screen.details.DetailsScreen
import com.app.albums.screen.home.HomeScreen
import com.app.albums.screen.home.HomeVM
import com.app.presentation.viewmodel.AppViewModel

class AppNavHost(
    private val activity: ComponentActivity,
    private val navController: NavHostController
) {
    private val homeVM: HomeVM by activity.viewModels()

    //TODO: make architecture
    @Composable
    fun Setup() {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                HomeScreen(activity, navController).Content()
            }
            composable(Screen.Details.route) {
                DetailsScreen(activity, navController).Content()
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