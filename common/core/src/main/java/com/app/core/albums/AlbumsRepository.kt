package com.app.core.albums

import retrofit2.Response
import retrofit2.http.GET

interface AlbumsRepository {

    @GET("albums")
    fun getAlbums(): Response<List<Album>>

    @GET("photos")
    fun getPhotos(): Response<List<Photo>>
}