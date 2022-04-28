package com.app.data.api.photos

import com.app.core.domain.photos.PhotosRepository
import com.app.core.domain.photos.model.Photo
import retrofit2.Response

class PhotosRepositoryImpl(val api: PhotosApi) : PhotosRepository {

    override suspend fun getPhotos(): Response<List<Photo>> {
        return api.getPhotos()
    }
}