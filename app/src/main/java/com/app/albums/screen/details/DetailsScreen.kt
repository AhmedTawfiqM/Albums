package com.app.albums.screen.details

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.app.presentation.activity.screen.AppScreen
import com.app.presentation.viewmodel.AppViewModel

class DetailsScreen(
    override val activity: ComponentActivity,
    override val navController: NavHostController
) : AppScreen<DetailsVM> {

    override val vm: AppViewModel by activity.viewModels()

    @Composable
    override fun Content() {
        Text(text = "Hello Details Screen")
    }

}