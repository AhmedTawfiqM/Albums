package com.app.core.domain.albums.source

import com.app.core.domain.albums.model.AlbumDto
import retrofit2.Response

interface AlbumsDataSrc {
    suspend fun getAlbums(userId: Int): Response<List<AlbumDto>>
}