package com.app.albums.screen.albums_details

import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.app.core.domain.albums.model.Album
import com.app.presentation.activity.screen.AppScreen
import com.app.presentation.activity.screen.ScreenHost

class AlbumDetailsScreen(
    override val host: ScreenHost,
    val album: Album
) : AppScreen<AlbumsDetailsVM> {

    override val vm: AlbumsDetailsVM by host.activity.viewModels()

    @Composable
    override fun Content() {
        Text(text = "Hello Details Screen ${vm.photos.size}")
    }

}