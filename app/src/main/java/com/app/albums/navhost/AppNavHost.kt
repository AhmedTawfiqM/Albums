package com.app.albums.navhost

import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.albums.screen.details.DetailsScreen
import com.app.albums.screen.home.HomeScreen
import com.app.albums.screen.home.HomeVM
import com.app.presentation.activity.screen.ScreenHost
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppNavHost(
    override val activity: ComponentActivity,
    override val navController: NavHostController
) : ScreenHost {

    private val host: ScreenHost
        get() = this

    //TODO: make architecture
    @Composable
    fun Setup() {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                //val vm = hiltViewModel<HomeVM>()
                HomeScreen(host).Content()
            }
            composable(Screen.Details.route) {
                DetailsScreen(this@AppNavHost).Content()
            }
        }
    }

    //TODO: make reusable screen builder from screen sealed class
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