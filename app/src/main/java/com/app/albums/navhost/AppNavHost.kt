package com.app.albums.navhost

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.albums.screen.albums_details.AlbumDetailsScreen
import com.app.albums.screen.albums.AlbumsScreen
import com.app.presentation.activity.screen.ScreenHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppNavHost(
    override val activity: ComponentActivity,
    override val navController: NavHostController
) : ScreenHost {
    private val host: ScreenHost = this

    @Composable
    fun Setup() {
        NavHost(
            navController = navController,
            startDestination = Screen.Albums.route
        ) {
            screenBuilder(Screen.Albums) {
                //val vm = hiltViewModel<HomeVM>()
                AlbumsScreen(host).Content()
            }
            screenBuilder(Screen.AlbumDetails) {
                AlbumDetailsScreen(host).Content()
            }
        }
    }

    private fun NavGraphBuilder.screenBuilder(
        screen: Screen,
        arguments: List<NamedNavArgument> = emptyList(),
        content: @Composable (NavBackStackEntry) -> Unit
    ) {
        this.composable(
            route = screen.route,
            arguments = arguments
        ) {
            content(it)
        }
    }
}