package com.app.data.api.albums

import com.app.core.albums.AlbumsRepository
import com.app.core.albums.model.Album
import retrofit2.Response

class AlbumsRepositoryImpl(val api: AlbumsApi) : AlbumsRepository {

    override fun getAlbums(): Response<List<Album>> {
        return Response.success(FakeAlbums.albums)
    }
}