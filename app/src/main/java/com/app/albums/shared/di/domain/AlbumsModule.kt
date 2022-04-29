package com.app.albums.shared.di.domain

import com.app.core.domain.albums.use_case.GetAlbumsUseCase
import com.app.data.api.albums.AlbumsApi
import com.app.data.api.albums.AlbumsRepositoryImpl
import com.app.data.api.albums.source.LocalAlbumsDataSrc
import com.app.data.api.albums.source.RemoteAlbumsDataSrc
import com.app.data.api.photos.PhotosApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AlbumsModule {

    @Provides
    @Singleton
    fun provideAlbumsApiService(retrofit: Retrofit): AlbumsApi {
        return retrofit.create(AlbumsApi::class.java)
    }

    @Singleton
    @Provides
    fun providePhotosRemoteDataSrc(api: AlbumsApi): RemoteAlbumsDataSrc {
        return RemoteAlbumsDataSrc(api)
    }

    @Singleton
    @Provides
    fun providePhotosLocalDataSrc(api: AlbumsApi): LocalAlbumsDataSrc {
        return LocalAlbumsDataSrc()
    }

    @Singleton
    @Provides
    fun providePhotosRepository(
        api: PhotosApi,
        remoteSrc: RemoteAlbumsDataSrc,
        localSrc: LocalAlbumsDataSrc
    ): AlbumsRepositoryImpl {
        return AlbumsRepositoryImpl(remoteSrc, localSrc)
    }

    @Provides
    @Singleton
    fun provideGetPhotosUseCase(repository: AlbumsRepositoryImpl): GetAlbumsUseCase {
        return GetAlbumsUseCase(repository)
    }

}