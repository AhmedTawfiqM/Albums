package com.app.albums.screen.albums.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.core.domain.albums.model.Album

class AlbumsListView(val albums: List<Album>) {

    @Composable
    fun Content(onAlbumClick: (Album) -> Unit) {
        LazyColumn {
            items(albums) {
                AlbumItem(it, onAlbumClick)
            }
        }
    }

    @Composable
    private fun AlbumItem(
        album: Album,
        onAlbumClick: (Album) -> Unit
    ) {
        Divider(
            modifier = Modifier.height(1.dp).alpha(0.2f),
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            modifier = Modifier.clickable {
                onAlbumClick(album)
            },
            text = album.title ?: "",
            color = Color.Black,
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(10.dp))
    }

}