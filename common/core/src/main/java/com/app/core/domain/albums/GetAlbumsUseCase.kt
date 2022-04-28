package com.app.core.domain.albums

class GetAlbumsUseCase(private val repository: AlbumsRepository) {

    suspend fun invoke(userId: Int) {
        repository.getAlbums(userId = userId)
    }
}