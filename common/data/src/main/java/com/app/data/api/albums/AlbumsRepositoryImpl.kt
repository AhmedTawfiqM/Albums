package com.app.data.api.albums

import com.app.core.domain.albums.repository.AlbumsRepository
import com.app.core.domain.albums.model.AlbumDto
import retrofit2.Response

class AlbumsRepositoryImpl(val api: AlbumsApi) : AlbumsRepository {

    override suspend fun getAlbums(userId: Int): Response<List<AlbumDto>> {
        return api.getAlbums(userId)
    }
}