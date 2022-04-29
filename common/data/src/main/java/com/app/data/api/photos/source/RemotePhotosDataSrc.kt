package com.app.data.api.photos.source

import com.app.core.domain.photos.model.PhotoDto
import com.app.core.domain.photos.source.PhotosDataSource
import com.app.data.api.photos.PhotosApi
import retrofit2.Response

class RemotePhotosDataSrc(val api: PhotosApi) : PhotosDataSource {
    override suspend fun getPhotos(albumId: Int): Response<List<PhotoDto>> {
        return api.getPhotos(albumId)
    }
}