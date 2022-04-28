package com.app.albums.shared.di

import com.app.data.api.albums.AlbumsRepositoryImpl
import com.app.data.api.photos.PhotosRepositoryImpl
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
        albumsRepo: AlbumsRepositoryImpl,
        photosRepo: PhotosRepositoryImpl,
    ): DataManager {
        return DataManager(
            albumsRepo = albumsRepo,
            photosRepo = photosRepo,
        )
    }
}