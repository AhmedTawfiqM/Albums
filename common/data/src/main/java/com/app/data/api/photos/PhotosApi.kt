package com.app.data.api.photos

import com.app.core.domain.photos.model.PhotoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotosApi {

    @GET("albums/{albumId}/photos")
    suspend fun getPhotos(@Path("albumId") albumId: Int)
            : Response<List<PhotoDto>>
}