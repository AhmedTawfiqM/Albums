package com.app.data.api.albums.source

import com.app.core.domain.albums.model.AlbumDto
import com.app.core.domain.albums.source.AlbumsDataSrc
import com.app.data.api.albums.AlbumsApi
import retrofit2.Response

class RemoteAlbumsDataSrc(val api: AlbumsApi) : AlbumsDataSrc {

    override suspend fun getAlbums(userId: Int): Response<List<AlbumDto>> {
        return api.getAlbums(userId)
    }
}