package com.app.data.api.photos

import com.app.core.domain.photos.PhotosRepository
import com.app.core.domain.photos.model.PhotoDto
import retrofit2.Response

class PhotosRepositoryImpl(val api: PhotosApi) : PhotosRepository {

    override suspend fun getPhotos(albumId: Int): Response<List<PhotoDto>> {
        return api.getPhotos(albumId)
    }
}