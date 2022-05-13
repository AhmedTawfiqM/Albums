package com.app.presentation.activity.screen.builder

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.presentation.activity.screen.ScreenRoute


/**
 * this func is responsible to build nav screen by 'ScreenRoute'
 */
fun NavGraphBuilder.screenBuilder(
    screen: ScreenRoute,
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