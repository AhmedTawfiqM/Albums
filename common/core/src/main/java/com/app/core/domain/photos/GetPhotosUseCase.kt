package com.app.core.domain.photos

class GetPhotosUseCase(private val repository: PhotosRepository) {

    suspend fun invoke(userId: Int) {
        repository.getPhotos(albumId = userId)
    }
}