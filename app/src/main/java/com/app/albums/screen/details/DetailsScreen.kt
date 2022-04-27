package com.app.albums.screen.details

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.app.albums.screen.home.HomeVM
import com.app.presentation.activity.screen.AppScreen
import com.app.presentation.viewmodel.AppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

class DetailsScreen(
    override val activity: ComponentActivity,
    override val navController: NavHostController
) : AppScreen<DetailsVM> {

    override val vm: DetailsVM by activity.viewModels()

    @Composable
    override fun Content() {
        Text(text = "Hello Details Screen")
    }

}