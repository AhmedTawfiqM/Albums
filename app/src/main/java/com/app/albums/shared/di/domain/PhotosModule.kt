package com.app.albums.shared.di.domain

import com.app.data.api.photos.PhotosApi
import com.app.data.api.photos.PhotosRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PhotosModule {

    //TODO: add DataSrc class and Use Cases

    @Provides
    @Singleton
    fun providePhotosApiService(retrofit: Retrofit): PhotosApi {
        return retrofit.create(PhotosApi::class.java)
    }

    @Singleton
    @Provides
    fun providePhotosRepository(api: PhotosApi): PhotosRepositoryImpl {
        return PhotosRepositoryImpl(api)
    }
}