package com.app.data.api.albums

import com.app.core.domain.albums.model.AlbumDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumsApi {

    @GET("users/{userId}/albums")
    suspend fun getAlbums(@Path("userId") userId: Int)
            : Response<List<AlbumDto>>
}