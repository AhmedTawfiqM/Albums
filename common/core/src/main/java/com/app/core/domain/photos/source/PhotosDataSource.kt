package com.app.core.domain.photos.source

import com.app.core.domain.photos.model.PhotoDto
import retrofit2.Response

interface PhotosDataSource {
    suspend fun getPhotos(albumId: Int): Response<List<PhotoDto>>
}