package com.app.core.domain.albums

import com.app.core.domain.albums.model.AlbumDto
import retrofit2.Response

interface AlbumsRepository {
    suspend fun getAlbums(): Response<List<AlbumDto>>
}