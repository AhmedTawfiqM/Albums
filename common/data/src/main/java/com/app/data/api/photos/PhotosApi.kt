package com.app.data.api.photos

import com.app.core.domain.photos.model.PhotoDto
import retrofit2.Response
import retrofit2.http.GET

interface PhotosApi {
    @GET("photos")
    suspend fun getPhotos(): Response<List<PhotoDto>>
}