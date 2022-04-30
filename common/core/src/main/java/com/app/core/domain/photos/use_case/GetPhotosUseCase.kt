package com.app.core.domain.photos.use_case

import com.app.core.domain.photos.model.PhotoDto
import com.app.core.domain.photos.repository.PhotosRepository
import retrofit2.Response

class GetPhotosUseCase (private val repository: PhotosRepository) {

    suspend fun invoke(userId: Int): Response<List<PhotoDto>> {
        return repository.getPhotos(albumId = userId)
    }
}