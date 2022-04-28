package com.app.albums.screen.albums_details

import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.app.albums.navhost.NavHostArgument
import com.app.core.domain.albums.model.Album
import com.app.presentation.activity.screen.AppScreen
import com.app.presentation.activity.screen.ScreenHost

class AlbumDetailsScreen(
    override val host: ScreenHost,
) : AppScreen<AlbumDetailsVM> {

    override val vm: AlbumDetailsVM by host.activity.viewModels()

    @Composable
    override fun Content() {
        LoadPhotos()
        Text(text = "Hello Details Screen ${vm.photos.size}")
    }

    @Composable
    private fun LoadPhotos() {
        val album = NavHostArgument.getValue<Album>()
        LaunchedEffect(true) {
            vm.fetchPhotos(album.id)
        }
    }

}