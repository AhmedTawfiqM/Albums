package com.app.albums.screen.albums

import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.albums.navhost.Screen
import com.app.presentation.activity.screen.AppScreen
import com.app.presentation.activity.screen.ScreenHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumsScreen(
    override val host: ScreenHost
) : AppScreen<AlbumsVM> {

    //TODO: move Creation to AppScreen
    override val vm: AlbumsVM by activity().viewModels()

    @Composable
    override fun Content() {
        Text(modifier = Modifier.clickable {
            navigate(Screen.Details)
        }, text = "Hello Home Screen: ${vm.albums.size}")
    }

}