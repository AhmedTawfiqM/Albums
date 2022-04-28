package com.app.data.api.albums

import com.app.core.domain.albums.AlbumsRepository
import com.app.core.domain.albums.model.AlbumDto
import retrofit2.Response

class AlbumsRepositoryImpl(val api: AlbumsApi) : AlbumsRepository {

    override suspend fun getAlbums(): Response<List<AlbumDto>> {
        return api.getAlbums()
    }
}