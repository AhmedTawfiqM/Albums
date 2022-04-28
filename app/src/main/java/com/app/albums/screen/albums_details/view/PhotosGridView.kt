package com.app.albums.screen.albums_details.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.app.core.domain.albums.model.Album
import com.app.core.domain.photos.model.Photo

class PhotosGridView(
    private val photos: List<Photo>,
    private val cells: Int = 3
) {

    @ExperimentalFoundationApi
    @Composable
    fun Content(onPhotoClick: (Photo) -> Unit) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(cells)
        ) {
            items(photos) {
                GridItemView(it, onPhotoClick)
            }
        }
    }

    @Composable
    private fun GridItemView(
        photo: Photo,
        onPhotoClick: (Photo) -> Unit
    ) {

        Image(
            modifier = Modifier
                .size(128.dp)
                .clickable {
                    onPhotoClick(photo)
                },
            painter = rememberAsyncImagePainter(photo.url),
            contentDescription = null,
        )
    }
}