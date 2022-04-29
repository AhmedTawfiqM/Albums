package com.app.core.domain.albums.use_case

import com.app.core.domain.albums.model.AlbumDto
import com.app.core.domain.albums.repository.AlbumsRepository
import retrofit2.Response

class GetAlbumsUseCase(private val repository: AlbumsRepository) {

    suspend fun invoke(userId: Int): Response<List<AlbumDto>> {
        return repository.getAlbums(userId = userId)
    }
}