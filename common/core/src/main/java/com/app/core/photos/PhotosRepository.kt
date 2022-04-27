package com.app.core.photos

import com.app.core.photos.model.Photo
import retrofit2.Response

interface PhotosRepository {
    fun getPhotos(): Response<List<Photo>>
}