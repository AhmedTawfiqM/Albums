package com.app.albums.screen.details

import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.app.presentation.activity.screen.AppScreen
import com.app.presentation.activity.screen.ScreenHost

class DetailsScreen(
    override val host: ScreenHost
) : AppScreen<DetailsVM> {

    override val vm: DetailsVM by host.activity.viewModels()

    @Composable
    override fun Content() {
        Text(text = "Hello Details Screen ${vm.photos.size}")
    }

}