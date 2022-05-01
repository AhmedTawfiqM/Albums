package com.app.albums.navhost

import androidx.activity.ComponentActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.albums.screen.albums_details.AlbumDetailsScreen
import com.app.albums.screen.albums.AlbumsScreen
import com.app.presentation.activity.screen.NavControllerHost
import com.app.presentation.activity.screen.builder.screenBuilder

class AlbumsNavHost(
    override val activity: ComponentActivity,
    override val navController: NavHostController
) : NavControllerHost {
    private val host: NavControllerHost = this

    @Composable
    override fun Setup() {
        NavHost(
            navController = navController,
            startDestination = Screen.Albums.route
        ) {
            screenBuilder(Screen.Albums) {
                AlbumsScreen(host).ScreenContent()
            }
            screenBuilder(Screen.AlbumDetails) {
                AlbumDetailsScreen(host).ScreenContent()
            }
        }
    }
}