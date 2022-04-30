package com.app.core.domain.photos.repository

import com.app.core.domain.photos.model.PhotoDto
import retrofit2.Response

interface PhotosRepository {
    suspend fun getPhotos(albumId: Int): Response<List<PhotoDto>>
}