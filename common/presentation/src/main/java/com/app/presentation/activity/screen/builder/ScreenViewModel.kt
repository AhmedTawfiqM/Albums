package com.app.presentation.activity.screen.builder

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.presentation.activity.screen.AppScreen
import com.app.presentation.activity.screen.ScreenRoute
import com.app.presentation.viewmodel.AppViewModel

/**
 * this func is concise and reusable to Create VMs of Screens
 */
inline fun <reified vm : AppViewModel> AppScreen<vm>.createVM(): vm {
    val vm: vm by activity().viewModels()
    return vm
}

