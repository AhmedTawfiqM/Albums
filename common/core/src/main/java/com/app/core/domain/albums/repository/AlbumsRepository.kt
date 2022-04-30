package com.app.core.domain.albums.repository

import com.app.core.domain.albums.model.AlbumDto
import retrofit2.Response

interface AlbumsRepository {
    suspend fun getAlbums(userId: Int): Response<List<AlbumDto>>
}