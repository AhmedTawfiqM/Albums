package com.app.data.api.albums

import com.app.core.domain.albums.repository.AlbumsRepository
import com.app.core.domain.albums.model.AlbumDto
import com.app.data.api.albums.source.LocalAlbumsDataSrc
import com.app.data.api.albums.source.RemoteAlbumsDataSrc
import retrofit2.Response

class AlbumsRepositoryImpl(
    private val remoteDataSrc: RemoteAlbumsDataSrc,
    private val localDataSrc: LocalAlbumsDataSrc
) : AlbumsRepository {

    override suspend fun getAlbums(userId: Int): Response<List<AlbumDto>> {
        return remoteDataSrc.getAlbums(userId)
    }
}