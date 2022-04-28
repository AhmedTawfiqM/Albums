package com.app.albums.shared.di

import com.app.core.albums.AlbumsRepository
import com.app.core.photos.PhotosRepository
import com.app.data.data_manager.DataManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataManagerModule {

    @Singleton
    @Provides
    fun provideDataManager(
        albumsRepo: AlbumsRepository,
        photosRepo: PhotosRepository
    ): DataManager {
        return DataManager(
            albumsRepo = albumsRepo,
            photosRepo = photosRepo,
        )
    }
}