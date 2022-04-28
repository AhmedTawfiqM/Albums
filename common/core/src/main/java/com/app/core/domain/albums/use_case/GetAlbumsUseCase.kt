package com.app.core.domain.albums.use_case

import com.app.core.domain.albums.repository.AlbumsRepository

class GetAlbumsUseCase(private val repository: AlbumsRepository) {

    suspend fun invoke(userId: Int) {
        repository.getAlbums(userId = userId)
    }
}