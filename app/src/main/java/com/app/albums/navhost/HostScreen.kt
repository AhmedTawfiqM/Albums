package com.app.albums.navhost

import com.app.presentation.activity.screen.ScreenRoute

sealed class Screen(override val route: String) : ScreenRoute {
    object Home : Screen(route = "home_screen")
    object Details : Screen(route = "details_screen")
}