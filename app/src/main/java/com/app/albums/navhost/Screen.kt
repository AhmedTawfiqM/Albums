package com.app.albums.navhost

import com.app.presentation.activity.screen.ScreenRoute

sealed class Screen(override val route: String) : ScreenRoute {
    object Albums : Screen(route = "home_screen")
    object AlbumDetails : Screen(route = "details_screen")

    fun withArg(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}