package com.app.core.domain.photos

import com.app.core.domain.photos.model.Photo
import retrofit2.Response

interface PhotosRepository {
    suspend fun getPhotos(): Response<List<Photo>>
}