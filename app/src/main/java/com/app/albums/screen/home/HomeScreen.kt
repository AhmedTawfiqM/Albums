package com.app.albums.screen.home

import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.app.data.data_manager.DataManager
import com.app.presentation.activity.screen.AppScreen
import com.app.presentation.activity.screen.ScreenHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class HomeScreen(
    override val host: ScreenHost
) : AppScreen<HomeVM> {

    //TODO: move Creation to AppScreen
    override val vm: HomeVM by activity().viewModels()

    @Composable
    override fun Content() {
        Text(text = "Hello Home Screen: ${vm.albums.size}")
    }

}