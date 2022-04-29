package com.app.data.api.albums.source

import com.app.core.domain.albums.model.AlbumDto
import com.app.core.domain.albums.source.AlbumsDataSrc
import com.app.data.api.albums.AlbumsApi
import retrofit2.Response

class LocalAlbumsDataSrc : AlbumsDataSrc {

    override suspend fun getAlbums(userId: Int): Response<List<AlbumDto>> {
        //TODO: implement
        return Response.success(emptyList())
    }
}