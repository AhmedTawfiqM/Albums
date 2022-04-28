package com.app.albums.navhost

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.albums.screen.details.DetailsScreen
import com.app.albums.screen.home.HomeScreen
import com.app.presentation.activity.screen.ScreenHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppNavHost(
    override val activity: ComponentActivity,
    override val navController: NavHostController
) : ScreenHost {

    private val host: ScreenHost
        get() = this

    private val startDestination = Screen.Home

    //TODO: make architecture
    @Composable
    fun Setup() {
        NavHost(
            navController = navController,
            startDestination = startDestination.route
        ) {
            screenBuilder(Screen.Home) {
                //val vm = hiltViewModel<HomeVM>()
                HomeScreen(host).Content()
            }
            screenBuilder(Screen.Details) {
                DetailsScreen(this@AppNavHost).Content()
            }
        }
    }

    private fun NavGraphBuilder.screenBuilder(
        screen: Screen,
        content: @Composable (NavBackStackEntry) -> Unit
    ) {
        this.composable(screen.route) {
            content(it)
        }
    }
}