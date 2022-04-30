package com.app.albums.shared.di.domain

import com.app.core.domain.photos.repository.PhotosRepository
import com.app.core.domain.photos.source.PhotosDataSource
import com.app.core.domain.photos.use_case.GetPhotosUseCase
import com.app.data.api.photos.PhotosApi
import com.app.data.api.photos.PhotosRepositoryImpl
import com.app.data.api.photos.source.LocalPhotosDataSrc
import com.app.data.api.photos.source.RemotePhotosDataSrc
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PhotosModule {

    @Provides
    @Singleton
    fun providePhotosApiService(retrofit: Retrofit): PhotosApi {
        return retrofit.create(PhotosApi::class.java)
    }

    @Singleton
    @Provides
    fun providePhotosRemoteDataSrc(api: PhotosApi): RemotePhotosDataSrc {
        return RemotePhotosDataSrc(api)
    }

    @Singleton
    @Provides
    fun providePhotosLocalDataSrc(api: PhotosApi): LocalPhotosDataSrc {
        return LocalPhotosDataSrc()
    }

    @Singleton
    @Provides
    fun providePhotosRepository(
        api: PhotosApi,
        remoteSrc: RemotePhotosDataSrc,
        localSrc: LocalPhotosDataSrc
    ): PhotosRepository {
        return PhotosRepositoryImpl(remoteSrc, localSrc)
    }

    @Provides
    @Singleton
    fun provideGetPhotosUseCase(repository: PhotosRepository): GetPhotosUseCase {
        return GetPhotosUseCase(repository)
    }

}