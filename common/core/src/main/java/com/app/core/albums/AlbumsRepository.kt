package com.app.core.albums

import com.app.core.albums.model.Album
import com.app.core.photos.model.Photo
import retrofit2.Response
import retrofit2.http.GET

interface AlbumsRepository {
    fun getAlbums(): Response<List<Album>>
}