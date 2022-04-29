package com.app.core.domain.photos.use_case

import com.app.core.domain.photos.repository.PhotosRepository

class GetPhotosUseCase(private val repository: PhotosRepository) {

    suspend fun invoke(userId: Int) {
        repository.getPhotos(albumId = userId)
    }
}