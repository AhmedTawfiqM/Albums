package com.app.data.api.photos

import com.app.core.domain.photos.repository.PhotosRepository
import com.app.core.domain.photos.model.PhotoDto
import com.app.data.api.photos.source.LocalPhotosDataSrc
import com.app.data.api.photos.source.RemotePhotosDataSrc
import retrofit2.Response

class PhotosRepositoryImpl(
    private val remoteDataSrc: RemotePhotosDataSrc,
    private val localDataSrc: LocalPhotosDataSrc
) : PhotosRepository {

    override suspend fun getPhotos(albumId: Int): Response<List<PhotoDto>> {
        return remoteDataSrc.getPhotos(albumId)
    }
}